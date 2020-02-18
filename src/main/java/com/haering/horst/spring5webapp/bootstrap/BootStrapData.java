package com.haering.horst.spring5webapp.bootstrap;

import com.haering.horst.spring5webapp.domain.Author;
import com.haering.horst.spring5webapp.domain.Book;
import com.haering.horst.spring5webapp.domain.Publisher;
import com.haering.horst.spring5webapp.repositories.AuthorRepository;
import com.haering.horst.spring5webapp.repositories.BookRepository;
import com.haering.horst.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1252234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("Jee Development without EJBs", "3232325");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+ this.bookRepository.count());

        Publisher wesley = new Publisher();
        publisherRepository.save(wesley);
        System.out.println("Number of publishers: "+ this.publisherRepository.count());
    }
}
