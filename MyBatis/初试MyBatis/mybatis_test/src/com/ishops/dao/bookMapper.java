package com.ishops.dao;

import com.ishops.bean.Book;

public interface bookMapper {
	public Book selectBook(int id);	//返回类型是book  javaBean
}
