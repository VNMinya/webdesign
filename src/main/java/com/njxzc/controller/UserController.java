package com.njxzc.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njxzc.dao.UserDao;
import com.njxzc.po.MyUser;
import com.njxzc.po.UserForm;

import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller(value = "userController")
public class UserController {
	@Resource
	private UserDao userDao;
	public void test() {
		/**
		 * 根据id查询人员
		 */
		MyUser auser = userDao.selectUserById(1);
		System.out.println(auser);
		System.out.println("================");
		/**
		 * 根据name查询人员
		 */
		List<MyUser> li = userDao.selectUserByName("陈恒");
		for (MyUser myUser : li) {
			System.out.println(myUser);
		}
		// 添加一个用户
		MyUser addmu = new MyUser();
		addmu.setUname("陈恒");
		addmu.setUsex("男");
		int add = userDao.addUser(addmu);
		System.out.println("添加了" + add + "条记录");
		System.out.println("================");
		// 修改一个用户
		MyUser updatemu = new MyUser();
		updatemu.setUid(1);
		updatemu.setUname("张三");
		updatemu.setUsex("女");
		int up = userDao.updateUser(updatemu);
		System.out.println("修改了" + up + "条记录");
		System.out.println("================");
		// 删除一个用户
		int dl = userDao.deleteUser(9);
		System.out.println("删除了" + dl + "条记录");
		System.out.println("================");
		// 查询所有用户
		List<MyUser> list = userDao.selectAllUser();
		for (MyUser myUser : list) {
			System.out.println(myUser);
		}
	}

	// 得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	private static final Log logger = LogFactory.getLog(UserController.class);
	// 将服务依赖注入到属性userService
	@Autowired
	public UserService userService;

	/**
	 * 处理登录
	 */
	@RequestMapping("/login")
	public String login(UserForm user, HttpSession session, Model model) {
		if (userService.login(user)) {
			session.setAttribute("u", user);
			logger.info("成功");
			return "main";// 登录成功，跳转到main.jsp
		} else {
			logger.info("失败");
			model.addAttribute("messageError", "用户名或密码错误");
			return "login";
		}
	}

	/**
	 * 处理注册
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute("user") UserForm user) {
		if (userService.register(user)) {
			logger.info("成功");
			return "login";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("user")与model.addAttribute("user", user)功能相同
			// 在register.jsp页面上可以使用EL表达式${user.uname}取出ModelAttribute的uname值
			return "register";// 返回register.jsp
		}
	}
}
