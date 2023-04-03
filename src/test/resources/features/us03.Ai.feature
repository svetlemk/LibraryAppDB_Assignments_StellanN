@us03_Ai
Feature: Default
   @ui @db
   Scenario: US03_AC01_TC01_VP_Verify book categories with DB
    Given the "librarian" on the home page_Ai
    When the user navigates to "Books" page_Ai
    And the user clicks book categories_Ai
    Then verify book categories must match book_categories table from db_Ai