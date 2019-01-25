package org.rakesh.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.rakesh.graphql.graphqldemo.exception.BookNotFoundException;
import org.rakesh.graphql.graphqldemo.model.Author;
import org.rakesh.graphql.graphqldemo.model.Book;
import org.rakesh.graphql.graphqldemo.repository.AuthorRepository;
import org.rakesh.graphql.graphqldemo.repository.BookRepository;

/**
 * Created by Rakesh on 1/24/19.
 */
public class Mutation implements GraphQLMutationResolver {

  private BookRepository bookRepository;
  private AuthorRepository authorRepository;

  public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public Author newAuthor(String firstName, String lastName) {
    Author author = new Author();
    author.setFirstName(firstName);
    author.setLastName(lastName);

    authorRepository.save(author);

    return author;
  }

  public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
    Book book = new Book();
    book.setAuthor(new Author(authorId));
    book.setTitle(title);
    book.setIsbn(isbn);
    book.setPageCount(pageCount != null ? pageCount : 0);

    bookRepository.save(book);

    return book;
  }

  public boolean deleteBook(Long id) {
    bookRepository.deleteById(id);
    return true;
  }

  public Book updateBookPageCount(Integer pageCount, Long id) {
    Book book = bookRepository.findById(id).get();
    if(book == null) {
      throw new BookNotFoundException("The book to be updated was not found", id);
    }
    book.setPageCount(pageCount);
    bookRepository.save(book);
    return book;
  }





}
