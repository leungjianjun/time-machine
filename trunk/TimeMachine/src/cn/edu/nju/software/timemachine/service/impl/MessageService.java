package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.Message;
import cn.edu.nju.software.timemachine.service.IMessageService;

@Service("messageService")
public class MessageService<T extends Message> extends ServiceImpl<T> implements IMessageService<T> {

}
