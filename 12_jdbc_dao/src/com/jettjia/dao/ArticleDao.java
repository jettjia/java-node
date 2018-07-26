package com.jettjia.dao;

/**
 *  定义操作数据库的接口
 */
public interface ArticleDao {
	
	/**
	 * 查询所有文章
	 */
	void findAll();
	
	/**
	 * 修改文章标题
	 * @param id
	 * @param title
	 */
	void updateTitle(int id, String title);
}
