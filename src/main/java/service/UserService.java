package service;

import com.njxzc.po.UserForm;

public interface UserService {
	boolean login(UserForm user);
	boolean register(UserForm user);
}
