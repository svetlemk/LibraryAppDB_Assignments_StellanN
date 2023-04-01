@us03
Feature: Default
   @ui @db
   Scenario: US03_AC01_TC01_VP_Verify book categories with DB
    Given the "librarian" on the home page
    When the user navigates to "Books" page
    And the user clicks book categories
    Then verify book categories must match book_categories table from db