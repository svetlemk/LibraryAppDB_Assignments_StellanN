package com.library.steps;


import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_BorrowedBooks {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashboardPage = new DashBoardPage();
    String actualBorrowedBooksNumber;


    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {
        BrowserUtil.waitFor(1);
        loginPage.login(user);
    }


    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        BrowserUtil.waitFor(1);
        actualBorrowedBooksNumber = dashboardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        // This Scenario DB result is EXPECTED (using for comparing)

        // Connect to the Library2 database
        // DB_Util.createConnection(); // ==> connection will be created ny @db HOOKS


        //Run query to check amount of borrowed books (cell of result)
        DB_Util.runQuery("SELECT count(book_id) from book_borrow\n" +
                "WHERE returned_date IS NULL;");

        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBooksNumber = " + expectedBorrowedBooksNumber);


        // compare results with UI results (actual results)
        Assert.assertEquals(actualBorrowedBooksNumber, expectedBorrowedBooksNumber);


        // close DB connection
        // DB_Util.destroy(); // ==> connection will be closed ny @db HOOKS file

    }
}
