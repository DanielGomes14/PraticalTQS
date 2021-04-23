package tqs.ex2;
import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.java.ParameterType;
import static org.hamcrest.core.IsEqual.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> list_result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime isodate(String year, String month, String day) {
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }


    @Given("(a|another) book with the title {string}, written by {string}, published in {isodate}")
    public void newBook(final String title, final String author, final LocalDateTime ldt) {
        Book book = new Book(title, author, ldt);
        library.addBook(book);
    }


    @When("the customer searches for books published between {int} and {int}")
    public void searchByDateInterval(int year, int year2) {
        LocalDateTime dt = LocalDateTime.of(year,1,1,0,0);
        LocalDateTime dt2 = LocalDateTime.of(year2,1,1,0,0);
        Date date1 = Date.from(dt.toInstant(ZoneOffset.UTC));
        Date date2 = Date.from(dt2.toInstant(ZoneOffset.UTC));
        list_result = library.findBooks(date1, date2);
    }

    @When("the customer searches for books published with the title {string}")
    public void searchByBookTitle(String book_title) {
        list_result = library.findBooksByTitle(book_title);
    }
    @When("the customer searches for books published with the author {string}")
    public void searchByBookAuthor(String book_title) {
        list_result = library.findBooksByAuthor(book_title);
    }

    @Then("{int} books should have been found")
    public void verifyResultSize(int num) {
        assertThat(list_result.size(), equalTo(num));
    }


    @And("Book {int} should have the title {string}")
    public void verifyBookTitle(int index, String name) {
        assertThat(
                list_result.get(index-1).getTitle(),equalTo(name)
        );
    }

}

