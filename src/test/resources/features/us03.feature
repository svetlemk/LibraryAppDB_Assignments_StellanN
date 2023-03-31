@B28G52-119
Feature: Default


  @B28G52-120
  Scenario: US03_AC01_TC01_VP_Verify book categories with DB
    Given the "librarian" on the home page VP
    When the user navigates to "Books" page VP
    And the user clicks book categories VP
    Then verify book categories must match book_categories table from db VP