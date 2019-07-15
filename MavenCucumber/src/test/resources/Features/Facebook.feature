Feature: Facebook SignUp functionality
  As a user I want to create new account in facebook singnUp page

  Scenario: I want to create a new account in facebook singnUp page
    Given I am in facebook signUp page
    When I enter Firstname "Forhad" in firstname text box
    When I enter lastname "Uddin" in lastname text box
    When I enter email "Forhad@yahoo.com" in email text box
    When I enter againEmail "Forhad@yahoo.com" in re-email text box
    When I enter password "Forhadr5433" in password text box
    Then I will be able to create new facebook account
