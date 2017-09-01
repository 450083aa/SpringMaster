package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArgsAspectTest {

	private ApplicationContext ctx;

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/args/conf-args.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserServiceExt userServiceExt = ctx.getBean("userServiceExt",
				UserServiceExt.class);

		User user = new User();
		// 织入横切逻辑
		userService.addUser(user);
		// 织入横切逻辑
		userService.modifyUser(user);
		// 织入横切逻辑
		userService.delUser(user);
		// userServiceExt继承userService，因此也会被织入横切逻辑
		userServiceExt.addUser(user);
		// userServiceExt继承userService，因此也会被织入横切逻辑
		userServiceExt.modifyUser(user);
		// userServiceExt继承userService，因此也会被织入横切逻辑
	}
}
