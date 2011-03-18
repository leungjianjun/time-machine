package cn.edu.nju.software.timemachine.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.service.ICategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CategoryServiceTest {
	
	@Autowired  
	private ICategoryService<Category> categoryService;

	public void setCategoryService(ICategoryService<Category> categoryService) {
		this.categoryService = categoryService;
	}

	public ICategoryService<Category> getCategoryService() {
		return categoryService;
	}
	
	@Test
	public void nothingTest(){
		
	}

}
