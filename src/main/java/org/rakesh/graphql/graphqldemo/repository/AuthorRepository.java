package org.rakesh.graphql.graphqldemo.repository;

import org.rakesh.graphql.graphqldemo.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rakesh on 1/24/19.
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {

}
