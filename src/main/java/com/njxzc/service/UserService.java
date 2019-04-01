package com.njxzc.service;


import com.njxzc.po.MyUser;
import com.njxzc.po.UserForm;

public interface UserService {
	boolean login(MyUser user);
	boolean register(MyUser user);
}
