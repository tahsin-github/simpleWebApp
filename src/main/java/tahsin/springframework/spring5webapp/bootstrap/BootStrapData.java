package tahsin.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tahsin.springframework.spring5webapp.domain.Author;
import tahsin.springframework.spring5webapp.domain.Book;
import tahsin.springframework.spring5webapp.domain.Publisher;
import tahsin.springframework.spring5webapp.repositories.AuthorRepository;
import tahsin.springframework.spring5webapp.repositories.BookRepository;
import tahsin.springframework.spring5webapp.repositories.PublisherRepository;

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

        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher publisher = new Publisher();

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisher.setName("SFG Publication");
        publisher.setAddressLine1("55");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setZip("7800");
        publisherRepository.save(publisher);



        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);



        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);



        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "321213");

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Books for the publisher : " + publisher.getBooks().size());
    }
}
