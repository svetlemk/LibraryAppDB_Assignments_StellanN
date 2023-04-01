package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_StepDef_VP {

    BookPage bookPage;
    List<String> actualCategoryList ;

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
            bookPage = new BookPage();

            actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
            System.out.println("actualCategoryList = " + actualCategoryList);
            actualCategoryList.remove(0);
            System.out.println("------- AFTER REMOVE FIRST ONE --------");
            System.out.println("actualCategoryList = " + actualCategoryList);

    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        DB_Util.runQuery("SELECT name from book_categories");
        // 3 - store this info inside the list >> EXPECTED
        List<String> expectedCategoryList = DB_Util.getColumnDataAsList(1);

        //compare UI vs DB
        Assert.assertEquals(expectedCategoryList, actualCategoryList);
    }



}










