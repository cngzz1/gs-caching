package com.example.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class AppRunner<E> implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final BookRepository<String, Book<String, E>> bookRepository;

	public AppRunner(BookRepository<String, Book<String, E>> bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		for (String s : Collections.unmodifiableList(Arrays.asList(".... Fetching books",
				String.format("isbn-1234 -->%s", bookRepository.getByIsbn("isbn-1234")),
				String.format("isbn-4567 -->%s", bookRepository.getByIsbn("isbn-4567")),
				String.format("isbn-1234 -->%s", bookRepository.getByIsbn("isbn-1234")),
				String.format("isbn-4567 -->%s", bookRepository.getByIsbn("isbn-4567")),
				String.format("isbn-1234 -->%s", bookRepository.getByIsbn("isbn-1234")),
				String.format("isbn-1234 -->%s", bookRepository.getByIsbn("isbn-1234"))))) {
			logger.info(s);
		}
	}

}
