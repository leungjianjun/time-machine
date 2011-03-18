package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.service.IPictureService;

@Service("pictureService")
public class PictureServiceImpl<T extends Picture> extends ServiceImpl<T> implements IPictureService<T> {

}
