package com.jettjia.test;

import org.junit.Test;

import com.jettjia.dao.ArticleDao;
import com.jettjia.dao.impl.ArticleDaoImpl;

public class TestArticleDaoImpl {

	@Test
	public void testFindAll() {
		// 面向父类编程 接口编程
		ArticleDao dao = new ArticleDaoImpl(); // 体现多态的特征
		dao.findAll();
	}
	
	@Test
	public void testUpdateTitle() {
		ArticleDao dao = new ArticleDaoImpl();
		dao.updateTitle(1, "1111");
	}

}
