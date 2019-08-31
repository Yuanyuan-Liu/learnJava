package com.licf.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
* 类描述:Controller层（API）做测试，这时候就得用到MockMvc了，你可以不必启动工程就能测试这些接口。
 * MockMvc实现了对Http请求的模拟，能够直接使用网络的形式，转换到Controller的调用，这样可以使得测试速度快、不依赖网络环境，而且提供了一套验证的工具，这样可以使得请求的验证统一而且很方便。
*
 * 在日常的开发中，我们一般会定义一个service层，用于实现业务逻辑，并且针对service层会有与之对应的齐全的覆盖率高的单元测试。
 * 而对于controller层，一般不怎么做单元测试，因为主要的核心业务逻辑都在service层里，controller层只是做转发，调用service层接口而已。
 * 但是还是建议使用单元测试简单的将controller的方法跑一下，看看转发和数据转换的代码是否能正常工作。
 *
 *
 * @author licanfeng
* @date 2019/3/14 11:07
* @version 1.0
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class LoginControllerTest {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    org.apache.shiro.mgt.SecurityManager securityManager;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setUp() throws Exception {
        //shiro测试需绑定securityManager
        ThreadContext.bind(securityManager);
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
//        User user =new User();
//        session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional //配置数据自动回滚 一般用在service层
    public void login() throws Exception {
        String json="{\"loginName\":\"licf\",\"pwd\":\"123456\"}";

        MvcResult mvcResult = mvc.perform(
                post("/admin/login")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        ).andExpect(status().isOk())
                .andDo(print())         //打印出请求和相应的内容
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        log.info("response status:" + status);
        String content = mvcResult.getResponse().getContentAsString();
        log.info("response content:" + content);
        Assert.assertTrue("成功", status == 200);

    }

    @Test
    public void logout() {
    }
}