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
		// Sqlsession �ײ������ Connection
		SqlSession session = sqlSessionFactory.openSession();
		try {
			bookMapper bm = session.getMapper(bookMapper.class);		//ֱ�� �ӿ�����class  �������� ��
			Book Book = bm.selectBook(2);								//sqlӳ���ļ��У�sql��䷽����Ӧ��id
			System.out.println(Book);
		} finally {
			session.close();
		}
		
		/*�������Ϸ�����
		 *��ͬ��:
		 *1.���趨��ӿ�
		 *2.bookMapper.xml 
		 *		sqlӳ���ļ� �е������ռ������д
		 *		sql�ķ���idҲ������д
		 *
		 */
		
		/*
		 * try { Book book =
		 * session.selectOne("com.ishops.dao.bookMapper.selectBook", 2);
		 * System.out.println(book); } finally { session.close(); }
		 */

	}

}
