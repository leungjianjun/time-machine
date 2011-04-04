package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.service.IPictureService;

@Service("pictureService")
@Transactional
public class PictureServiceImpl<T extends Picture> extends ServiceImpl<T> implements IPictureService<T> {

	/**
	 * id已经放在picture中
	 */
	public long addPicture(T picture) {
		dao.save(picture);
		return picture.getId();
	}

	@SuppressWarnings("unchecked")
	public T getPicture(long id) {
		return (T) dao.createQuery("from Picture as picture where picture.id = :id")
		           .setParameter("id", id).uniqueResult();
	}

}
