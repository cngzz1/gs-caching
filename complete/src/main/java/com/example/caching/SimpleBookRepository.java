package com.example.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository<E> implements BookRepository<String, Book<String, E>> {

	@Override
	@Cacheable("books")
	public Book<String, E> getByIsbn(String isbn) {
		simulateSlowService();
		return new Book<>(isbn, "Some book");
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
