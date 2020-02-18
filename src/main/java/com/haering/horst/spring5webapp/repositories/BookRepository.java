package com.haering.horst.spring5webapp.repositories;

import com.haering.horst.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
