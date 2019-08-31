package com.licf.demo;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* 类描述: 测试用例
 * SpringRunner：底层使用的是 JUnit4
 * SpringBootTest // 指定启动类
 * 普通Java测试，不涉及Spring Web项目，你可以省略@RunWith注解，这样系统会自动使用默认Runner来运行
 * 执行顺序是先执行before 再执行test 最后执行after
* @author licanfeng
* @date 2019/3/14 10:25
* @version 1.0
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("say you love me!");
	}

	@Test
	public void testOne(){
		System.out.println("test hello 1");
	}

	@Test
	public void testTwo(){
		System.out.println("test hello 2");
		TestCase.assertEquals(1, 1);
	}

	@Before
	public void testBefore(){
		System.out.println("before");
	}

	@After
	public void testAfter(){
		System.out.println("after");
	}

}
