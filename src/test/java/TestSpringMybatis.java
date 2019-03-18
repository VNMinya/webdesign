import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njxzc.controller.UserController;
public class TestSpringMybatis {

	public static void main(String[] args) {

		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController uc = (UserController)appCon.getBean("userController");
		uc.test();
	}
}
