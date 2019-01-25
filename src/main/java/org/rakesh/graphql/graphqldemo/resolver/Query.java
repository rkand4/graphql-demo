package org.rakesh.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.rakesh.graphql.graphqldemo.model.Author;
import org.rakesh.graphql.graphqldemo.model.Book;
import org.rakesh.graphql.graphqldemo.repository.AuthorRepository;
import org.rakesh.graphql.graphqldemo.repository.BookRepository;

/**
 * Created by Rakesh on 1/24/19.
 */
public class Query implements GraphQLQueryResolver {

  private BookRepository bookRepository;
  private AuthorRepository authorRepository;

  public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public Iterable<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  public Iterable<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public long countBooks() {
    return bookRepository.count();
  }
  public long countAuthors() {
    return authorRepository.count();
  }

}
