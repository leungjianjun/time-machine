package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;

@Service("userService")
public class UserServiceImpl<T extends User> extends ServiceImpl<T> implements IUserService<T> {
	

}
