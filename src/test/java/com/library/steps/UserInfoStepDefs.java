package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserInfoStepDefs {

    // USer log in and page navigation: common
    LoginPage loginPage;
    BookPage bookPage;
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {
        loginPage= new LoginPage();
        loginPage.login(user);
        BrowserUtil.waitFor(4);
    }

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        bookPage=new BookPage();
        BrowserUtil.waitFor(3);
        bookPage.navigateModule(moduleName);
        //BrowserUtil.waitFor(3);
    }
    //database connection
    String actualUserCount;
    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        // Make conn with database
        // DB_Util.createConnection();
        System.out.println("**********************************************");
        System.out.println("*** CONNECTION WILL BE DONE WITH HOOK CLASS***");
        System.out.println("**********************************************");

    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query="select count(id) from users"; // 1855
        DB_Util.runQuery(query);

        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);

    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        String query="select count(distinct id) from users";
        DB_Util.runQuery(query);
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        // MAKE ASSERTIONS
        Assert.assertEquals(expectedUserCount,actualUserCount);

        //CLOSE CONN
        // DB_Util.destroy();
        System.out.println("**********************************************");
        System.out.println("*** DESTROY  WILL BE DONE WITH HOOK CLASS***");
        System.out.println("**********************************************");


    }
}
