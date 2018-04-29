package com.jacobcadena.spring5webapp.respositories;

import com.jacobcadena.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
