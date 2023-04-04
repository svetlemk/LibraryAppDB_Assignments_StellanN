package com.library.steps;

import com.library.pages.LoginPage;
import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_StepDef_Ai {
    BookPage bookPage;
    LoginPage loginPage = new LoginPage();

    List<String> actualCategoryList2;
//    @And("the user clicks book categories")
//    public void theUserClicksBookCategories_Ai() {
//
//        bookPage.mainCategoryElement.click();
//        actualCategoryList2 = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
//
//        System.out.println("AactualCategoryList2 = "+ actualCategoryList2);
//
//        actualCategoryList2.remove(0);
//
//        System.out.println("---------AFTER REMOVE FIRST ONE-----------");
//        System.out.println("actualCategoryList2 = " + actualCategoryList2);
//
//    }
//    @Then("verify book categories must match book_categories table from db")
//    public void verifyBookCategoriesMustMatchBook_categoriesTableFromDb_Ai() {
//
//        DB_Util.runQuery("select name from book_categories2");
//
//        List<String> expectedCategoryList2 = DB_Util.getColumnDataAsList(1);
//
//        System.out.println("expectedCategoryList2 = "+ expectedCategoryList2);
//
//        Assert.assertEquals(expectedCategoryList2,actualCategoryList2);
//    }
}
