import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.njxzc.controller.UserControllerMybatis;
public class TestSpringMybatis {

	public static void main(String[] args) {

		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserControllerMybatis uc = (UserControllerMybatis)appCon.getBean("UserControllerMybatis");
		uc.test();
	}
}
