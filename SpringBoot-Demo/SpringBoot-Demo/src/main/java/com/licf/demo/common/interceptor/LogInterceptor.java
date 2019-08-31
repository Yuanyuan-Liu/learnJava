package com.licf.demo.common.interceptor;

import com.licf.demo.util.DateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

/**
 * 类描述: AOP请求日志拦截器
 * 主要是用来记录请求处理时间,内存占用,IP,请求参数等等
 *
 * 主要切点是controller层
 *
 * 不需要AfterThrowing 因为存在全局异常捕获
 * @author licanfeng
 * @date 2019/4/3 9:57
 * @version 1.0
 */
@Slf4j
@Aspect
@Component
public class LogInterceptor {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    RedisSessionDAO redisSessionDAO;

    private long startTimeMillis;

    private long endTimeMillis;

    /**
     * 定义包切点：controller层
     */
    @Pointcut("execution(* com.licf.demo.controller.*.*(..))")
    public void controller() {
    }

    /**
     * 定义注解切点：RequestMapping
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {
    }

    /**
     * 获取请求url，token，参数信息
     * @param joinPoint
     */
    @Before("controller()")
    public void doBefore(JoinPoint joinPoint) {
        startTimeMillis = System.currentTimeMillis();
        org.springframework.web.context.request.RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        log.info("===================== request start =====================", new Object[0]);
        log.info("URL:[ {} ]", new Object[] { request.getRequestURL() });
        log.info("Token=[ {} ]", new Object[] { request.getHeader("x-auth-token") });

        log.debug("HTTP_METHOD : " + request.getMethod());
        log.debug("IP : " + request.getRemoteAddr());
        log.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //打印请求参数信息
        printMap("Request Params", request.getParameterMap());
        log.info("===================== request end =====================\n", new Object[0]);
    }

    @After("controller()")
    public void doAfter(JoinPoint pjp) {
        endTimeMillis = System.currentTimeMillis();
    }

    /**
     * 环绕通知防止表单重复提交
     * 同一客户端在2秒内对同一URL的提交视为重复提交
     * 可以针对一些需要防止重复提交的方法加注解，比如insert，update，delete方法，效果可能更好
     * @throws Throwable 异常会被全局异常捕获 不需要在此catch
     * @return
     */
/*    @Around("controller()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ValueOperations<String, Integer> opsForValue = template.opsForValue();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("x-auth-token");
        HttpServletRequest request = attributes.getRequest();
        String key = token + "-" + request.getServletPath();
        // 如果缓存中有这个url视为重复提交
        if (opsForValue.get(key) == null) {
            Object o = pjp.proceed();
            //设置为2分钟过期
            opsForValue.set(key, 0, 2, TimeUnit.SECONDS);
            return o;
        } else {
            log.error("重复提交");
            return new Result(ResultStatusCode.REPEAT_REQUEST_NOT_ALLOWED, "小伙子你有点调皮哦o(*￣︶￣*)o");
        }
    }*/


    @AfterReturning(pointcut = "controller()", returning = "returnValue")
    public JoinPoint afterReturning(JoinPoint joinPoint, Object returnValue) {
        //returnValue 该形参可用于访问目标方法的返回值。
        log.info("===================== return start =====================", new Object[0]);

        org.springframework.web.context.request.RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        log.info("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                new SimpleDateFormat("hh:mm:ss.SSS").format(endTimeMillis), DateUtils.formatDateTime(endTimeMillis - startTimeMillis),
                request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
                (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);

        log.info("===================== return end =====================\n", new Object[0]);
        return joinPoint;
    }

    /**
     * 打印url请求参数
     * @param prefix
     * @param map
     */
    private void printMap(String prefix, Map map) {
        StringBuilder buf = new StringBuilder();
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            buf.append("  ");
            buf.append((String) entry.getKey());
            buf.append(" = ");
            try {
                buf.append(MAPPER.writeValueAsString(entry.getValue()));
                buf.append("\n");
            }
            catch (IOException e) {
                log.error("print map error", new Object[] { e.getMessage() });
            }
        }

        if (buf.length() > 0) {
            log.info("{}:\n{}", new Object[] { prefix, buf.substring(0, buf.length() - 1) });
        }
    }
}
