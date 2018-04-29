package com.jacobcadena.spring5webapp.bootstrap;

import com.jacobcadena.spring5webapp.model.Author;
import com.jacobcadena.spring5webapp.model.Book;
import com.jacobcadena.spring5webapp.model.Publisher;
import com.jacobcadena.spring5webapp.respositories.AuthorRepository;
import com.jacobcadena.spring5webapp.respositories.BookRepository;
import com.jacobcadena.spring5webapp.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){

        Publisher eric = new Publisher("Eric", "Alaniz");
        Publisher aaron = new Publisher("Aaron", "Guiterez");

        publisherRepository.save(eric);
        publisherRepository.save(aaron);

        // Jacob
        Author jacob = new Author("Jacob", "Cadena");
        Book jBook  = new Book("Domain Driven Design", "1234", eric);
        jacob.getBooks().add(jBook);
        jBook.getAuthors().add(jacob);


        authorRepository.save(jacob);
        bookRepository.save(jBook);


        // Michael
        Author michael = new Author("Michael", "Gonzalez");
        Book mBook  = new Book("J2EE Development without EJB", "1234", aaron);
        michael.getBooks().add(mBook);
        mBook.getAuthors().add(michael);


        authorRepository.save(michael);
        bookRepository.save(mBook);



    }
}
