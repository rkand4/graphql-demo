package org.rakesh.graphql.graphqldemo;

import org.rakesh.graphql.graphqldemo.model.Author;
import org.rakesh.graphql.graphqldemo.model.Book;
import org.rakesh.graphql.graphqldemo.repository.AuthorRepository;
import org.rakesh.graphql.graphqldemo.repository.BookRepository;
import org.rakesh.graphql.graphqldemo.resolver.BookResolver;
import org.rakesh.graphql.graphqldemo.resolver.Mutation;
import org.rakesh.graphql.graphqldemo.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);

			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
		};
	}

}

