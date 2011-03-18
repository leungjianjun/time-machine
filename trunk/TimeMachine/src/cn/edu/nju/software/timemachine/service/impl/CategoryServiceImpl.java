package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.service.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl<T extends Category> extends ServiceImpl<T> implements ICategoryService<T> {

	public boolean moveUser(Friend friend, Category fromC, Category toC) {
		// TODO Auto-generated method stub
		return false;
	}

}