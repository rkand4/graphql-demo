package org.rakesh.graphql.graphqldemo.repository;

import org.rakesh.graphql.graphqldemo.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rakesh on 1/24/19.
 */
public interface BookRepository extends CrudRepository<Book,Long> {

}
