import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.njxzc.controller.UserControllerMybatis;
public class TestSpringMybatis {
  /*
   * @Description:此类完成项目的各模块的测试功能；
   * @param [args]
   * @Return: void
   * @Author: Roy xu 
   * @Date: 4/1/2019 12:26 PM
  **/
	public static void main(String[] args) {

		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserControllerMybatis uc = (UserControllerMybatis)appCon.getBean("UserControllerMybatis");
		uc.test();
	}
}
