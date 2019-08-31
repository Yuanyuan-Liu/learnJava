package com.licf.demo.common.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 类描述: Spring Boot 处理器拦截器: 类似于Servlet开发中的过滤器Filter，用于处理器进行预处理和后处理。
 *
 * 定义一个Interceptor 非常简单方式也有几种，简单列举两种
 * 1、类要实现Spring 的HandlerInterceptor 接口
 * 2、类继承实现了HandlerInterceptor 接口的类，例如 已经提供的实现了HandlerInterceptor 接口的抽象类HandlerInterceptorAdapter
 *
 * 应用场景
 * 1、日志记录，可以记录请求信息的日志，以便进行信息监控、信息统计等。
 * 2、权限检查：如登陆检测，进入处理器检测是否登陆，如果没有直接返回到登陆页面。
 * 3、性能监控：典型的是慢日志。
 *
 * @author licanfeng
 * @date 2019/4/3 9:43
 * @version 1.0
 */
public class ViewInterceptor extends HandlerInterceptorAdapter {
    /**
     * 1.在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     * @return true
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 一定得为true，否则拦截器就无法生效了 返回false 直接退出
        // 当然可以随意各种对url的拦截处理
        // 可以在这里取出token 获取用户信息等
        return true;
    }

    /**
     * 2.在业务处理器处理请求执行完成后，生成视图之前执行。
     * 后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView（很少使用）
    */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            // 防止出现空指针
            // 在springboot中如果是错误页肯定不会出现mv为null的情况
            modelAndView.setViewName("/error");
            // 注意：该请求只是测试试用，并没有实际的意义
        }
    }

    /**
     * 3.在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
    */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
