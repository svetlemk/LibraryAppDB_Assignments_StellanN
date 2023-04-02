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

public class US03_booksCat_Ai {
    BookPage bookPage;
    LoginPage loginPage = new LoginPage();

    @Given("the {string} on the home page")
    public void theOnTheHomePage(String userType2) {
        loginPage.login(userType2);
    }
    @When("the user navigates to {string} page")
    public void theUserNavigatesToPage(String moduleName2) {
        bookPage = new BookPage();
        bookPage.navigateModule(moduleName2);
        BrowserUtil.waitFor(1);

    }
    List<String> actualCategoryList2;
    @And("the user clicks book categories")
    public void theUserClicksBookCategories() {

        bookPage.mainCategoryElement.click();
        actualCategoryList2 = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);

        System.out.println("actualCategoryList2 = "+ actualCategoryList2);

        actualCategoryList2.remove(0);

        System.out.println("---------AFTER REMOVE FIRST ONE-----------");
        System.out.println("actualCategoryList2 = " + actualCategoryList2);

    }
    @Then("verify book categories must match book_categories table from db")
    public void verifyBookCategoriesMustMatchBook_categoriesTableFromDb() {

        DB_Util.runQuery("select name from book_categories2");

        List<String>expectedCategoryList2 = DB_Util.getColumnDataAsList(1);

        System.out.println("expectedCategoryList2 = "+ expectedCategoryList2);

        Assert.assertEquals(expectedCategoryList2,actualCategoryList2);
    }



}
