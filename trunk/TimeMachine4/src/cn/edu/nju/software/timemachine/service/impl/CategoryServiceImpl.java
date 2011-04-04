package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.service.ICategoryService;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl<T extends Category> extends ServiceImpl<T> implements ICategoryService<T> {

	/**
	 * category 中一定要指定owner和name,如果name重复，或者owner不存在都会返回false<p>
	 * owner中只要指定id
	 */
	public boolean addCategory(T category) {
		if(dao.createQuery("from Category as category where category.name = :name and category.owner.id =:id")
				.setParameter("name", category.getName()).setParameter("id", category.getOwner().getId()).uniqueResult()!=null ||
				category.getName() == null ||
				category.getOwner()==null){
			return false;
		}else{
			dao.create(category);
			return true;
		}
		
	}

	

}
