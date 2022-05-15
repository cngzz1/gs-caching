package com.example.caching;

public class Book<K, T> {
	private T bookType;
	private K isbn;
	private K title;

	public Book(K isbn, K title) {
		this.isbn = isbn;
		this.title = title;
	}

	public K getIsbn() {
		return isbn;
	}

	public void setIsbn(K isbn) {
		this.isbn = isbn;
	}

	public K getTitle() {
		return title;
	}

	public void setTitle(K title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("Book{isbn='%s', title='%s'}", isbn, title);
	}

	public T getBookType(){
		return bookType;
	}

}
