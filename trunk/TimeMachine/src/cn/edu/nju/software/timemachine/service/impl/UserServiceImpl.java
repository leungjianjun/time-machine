package cn.edu.nju.software.timemachine.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;
import cn.edu.nju.software.timemachine.util.Constraint;

@Service("userService")
@SuppressWarnings("unchecked")
public class UserServiceImpl<T extends User> extends ServiceImpl<T> implements IUserService<T> {

	public User getUser(long id) {
		return (User) dao.createQuery("from User as user where user.id= :userId")
		                 .setParameter("userId", id).uniqueResult();
	}

	public User getUser(String email, String password) {
		return (User) dao.createQuery("from User as user where user.email= :email and user.password = :password")
                         .setParameter("email", email).setParameter("password",password).uniqueResult();
	}

	public List<User> searchUserByEmail(String email) {
		return dao.createQuery("from User as user where user.email = :email")
		          .setParameter("email", email).list();
		
	}

	public List<User> searchUserByName(String name) {
		return dao.createQuery("from User as user where user.name = :name")
        .setParameter("name", name).list();
	}

	public List<User> serchUser(Constraint constraint) {
		// TODO Auto-generated method stub
		return null;
	}

}
