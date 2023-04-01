package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_BookCategories_Ai {
    BookPage bookPage;
    LoginPage loginPage = new LoginPage();

    @Given("the {string} on the home page")
    public void theOnTheHomePage(String userType) {
        loginPage.login(userType);
    }
    @When("the user navigates to {string} page")
    public void theUserNavigatesToPage(String moduleName) {
    bookPage = new BookPage();
    bookPage.navigateModule(moduleName);
    BrowserUtil.waitFor(1);

    }
    List<String> actualCategoryList;
    @And("the user clicks book categories")
    public void theUserClicksBookCategories() {

        bookPage.mainCategoryElement.click();
        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);

        System.out.println("actualCategoryList = "+ actualCategoryList);

        actualCategoryList.remove(0);

        System.out.println("---------AFTER REMOVE FIRST ONE-----------");
        System.out.println("actualCategoryList = " + actualCategoryList);

    }
    @Then("verify book categories must match book_categories table from db")
    public void verifyBookCategoriesMustMatchBook_categoriesTableFromDb() {

        DB_Util.runQuery("select name from book_categories");

        List<String>expectedCategoryList = DB_Util.getColumnDataAsList(1);

        System.out.println("expectedCategoryList = "+ expectedCategoryList);

        Assert.assertEquals(expectedCategoryList,actualCategoryList);
    }



}




