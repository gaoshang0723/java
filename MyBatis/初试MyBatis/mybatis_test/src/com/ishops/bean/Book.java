package com.ishops.bean;

public class Book {
	private int book_id;
	private String book_name;
	private Double book_price;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getBook_price() {
		return book_price;
	}
	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_price=" + book_price + "]";
	}
	
}
