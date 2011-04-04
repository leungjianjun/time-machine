package cn.edu.nju.software.timemachine.service;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.entity.Friend;

public interface IFriendService<T extends Friend> extends IService<T> {
	public boolean moveUser(T friend,long fromCId,long toCId);
	public boolean addFriend(T friend,Category category);
}
