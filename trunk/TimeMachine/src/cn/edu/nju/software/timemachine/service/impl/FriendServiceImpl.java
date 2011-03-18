package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.service.IFriendService;

@Service("friendService")
public class FriendServiceImpl<T extends Friend> extends ServiceImpl<T> implements IFriendService<T> {

}
