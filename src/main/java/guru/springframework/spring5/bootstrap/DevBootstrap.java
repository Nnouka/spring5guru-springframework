package guru.springframework.spring5.bootstrap;

import guru.springframework.spring5.model.Author;
import guru.springframework.spring5.model.Book;
import guru.springframework.spring5.model.Publisher;
import guru.springframework.spring5.repositories.AuthorRepository;
import guru.springframework.spring5.repositories.BookRepository;
import guru.springframework.spring5.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher hpc = new Publisher("Harper Collins", "Molyko Buea");
        Book domainDrivenDesign = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(eric);


        authorRepository.save(eric);
        publisherRepository.save(hpc);
        domainDrivenDesign.setPublisher(hpc);
        bookRepository.save(domainDrivenDesign);
        //Rob
        Author rob = new Author("Rob", "Morison");
        Publisher hecks = new Publisher("HECKs", "New Town Limbe");
        Book robEJB = new Book("J2EE Java Development with EJB", "23444");
        rob.getBooks().add(robEJB);
        robEJB.getAuthors().add(rob);


        authorRepository.save(rob);
        publisherRepository.save(hecks);
        robEJB.setPublisher(hecks);
        bookRepository.save(robEJB);
    }
}
