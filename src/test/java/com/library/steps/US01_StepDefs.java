package com.library.steps;

import com.library.utility.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class US01_StepDefs {

    String actualUserCount;  //To store the actual user count

    //Background:
    //    Given Establish the database connection
    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        //CONNECTION IS DONE WITH HOOK CLASS
    }

    //US01_SCENARIO 1: verify users has unique IDs
    //    When Execute query to get all IDs from users
    //    Then verify all users has unique ID
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query="select count(id) from users"; // 1855
        DB_Util.runQuery(query);   //Runs the sql query provided and returns ResultSet object

        actualUserCount = DB_Util.getFirstRowFirstColumn();  //Gets 1st cell value (1st row x 1st column)
        System.out.println("actualUserCount = " + actualUserCount);

    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        String query="select count(distinct id) from users";
        DB_Util.runQuery(query);   //Runs the sql query provided and returns ResultSet object
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();  //Gets 1st cell value (1st row x 1st column)
        System.out.println("expectedUserCount = " + expectedUserCount); //Prints out the expected

        // MAKE ASSERTIONS
        Assert.assertEquals(expectedUserCount,actualUserCount); //Verifies if expected matches actual
    }

    //US01 - SCENARIO 2
    /*
    Scenario: verify users table columns
    When Execute query to get all columns
    Then verify the below columns are listed in result

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |
     */
    List<String> actualList;  //To store all the column names
    // US01-2
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users");  //Runs the sql query provided and returns ResultSet object
        actualList = DB_Util.getAllColumnNamesAsList(); // Get all the Column names into a list object
        System.out.println("actualList = " + actualList);
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedList) {  //Pass a list of strings with expected columns as listed above
        System.out.println("expectedList = " + expectedList);  //Prints out the expected
        // Assertions
        Assert.assertEquals(expectedList,actualList);  //Verifies if expected matches actual

        //CONNECTION IS CLOSED WITH HOOK CLASS
    }
}
