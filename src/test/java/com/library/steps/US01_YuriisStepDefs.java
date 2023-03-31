package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_YuriisStepDefs {

    String query;
    String actualColumnNames;
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        query="select * from users";

        DB_Util.runQuery(query);
        actualColumnNames = DB_Util.getAllColumnNamesAsList().toString();
        System.out.println("actualColumnName = " + actualColumnNames);


    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> columnsName) {

        query="select * from users";

        String expectedColumnNames=columnsName.toString();
        System.out.println("expectedColumnNames = " + expectedColumnNames);

        Assert.assertEquals(expectedColumnNames,actualColumnNames);


    }

}
