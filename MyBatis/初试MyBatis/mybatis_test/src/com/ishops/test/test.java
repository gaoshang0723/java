package com.ishops.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ishops.bean.Book;
import com.ishops.dao.bookMapper;

public class test {

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// Sqlsession 底层调用了 Connection
		SqlSession session = sqlSessionFactory.openSession();
		try {
			bookMapper bm = session.getMapper(bookMapper.class);		//直接 接口名。class  （代理类 ）
			Book Book = bm.selectBook(2);								//sql映射文件中，sql语句方法对应的id
			System.out.println(Book);
		} finally {
			session.close();
		}
		
		/*以下是老方法：
		 *不同点:
		 *1.无需定义接口
		 *2.bookMapper.xml 
		 *		sql映射文件 中的命名空间可随意写
		 *		sql的方法id也可随意写
		 *
		 */
		
		/*
		 * try { Book book =
		 * session.selectOne("com.ishops.dao.bookMapper.selectBook", 2);
		 * System.out.println(book); } finally { session.close(); }
		 */

	}

}
