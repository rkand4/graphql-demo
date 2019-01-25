package org.rakesh.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.rakesh.graphql.graphqldemo.model.Author;
import org.rakesh.graphql.graphqldemo.model.Book;
import org.rakesh.graphql.graphqldemo.repository.AuthorRepository;

/**
 * Created by Rakesh on 1/24/19.
 */
public class BookResolver implements GraphQLResolver<Book> {


  private AuthorRepository authorRepository;

  public BookResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Book book) {
    return authorRepository.findById(book.getAuthor().getId()).get();
  }

}
