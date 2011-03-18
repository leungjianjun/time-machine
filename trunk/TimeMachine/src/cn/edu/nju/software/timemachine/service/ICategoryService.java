package cn.edu.nju.software.timemachine.service;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.entity.Friend;

public interface ICategoryService<T extends Category> extends IService<T> {
	
	public boolean moveUser(Friend friend,Category fromC,Category toC);

}
