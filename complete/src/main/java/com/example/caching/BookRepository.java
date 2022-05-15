package com.example.caching;

public interface BookRepository<K, E> {

	E getByIsbn(K isbn);

}
