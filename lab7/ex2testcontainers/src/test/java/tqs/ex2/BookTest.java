package tqs.ex2;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import  java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@Testcontainers
@SpringBootTest
class BookTest {

    @Container
    private  static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres")
            .withUsername("duke")
            .withPassword("password")
            .withDatabaseName("test");

    @Autowired
    private BookRepository bookRepository;

    // requires Spring Boot >= 2.2.6
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgresqlContainer::getPassword);
        registry.add("spring.datasource.username", postgresqlContainer::getUsername);
    }
    @Test
    void testContainerExecution() {
        assertTrue(postgresqlContainer.isRunning());
    }

    @Test
    @Order(1)
    void testsaveBook(){
        Book b = new Book();
        b.setName("A Book");
        bookRepository.save(b);
    }

    @Test
    @Order(2)
    void testBooksCollection(){
        List<Book> books = bookRepository.findAll();
        assertThat(books).hasSize(1)
                .extracting(Book::getName)
                .contains("A Book");
    }

}