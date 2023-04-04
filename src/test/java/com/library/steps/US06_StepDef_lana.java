package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.* ;
import org.openqa.selenium.support.ui.Select;

import java.sql.ResultSet;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;


public class US06_StepDef_lana {
    BookPage bookPage;
    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
       bookPage.addBook.click();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        bookPage.bookName.sendKeys(bookName);
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {
        bookPage.isbn.sendKeys(isbn);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        bookPage.year.sendKeys(year);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        bookPage.author.sendKeys(author);
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String category) {
        Select select = new Select(bookPage.categoryDropdown);
        select.selectByVisibleText(category);
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
       bookPage.saveChanges.click();
    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String message) {
        bookPage.toastMessage.isDisplayed();
    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String bookName) {
        String query = "select name from books";
        ResultSet expectedName = DB_Util.runQuery(query);




    }


}
