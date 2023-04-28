Feature: Login with valid credentials

@sanity
  Scenario: Successful login with valid credentials
    Given User Launch Browser
    And Opens URL "http://localhost:8081/opencart/upload/index.php?route=common/home&language=en-gb"
    When User navigate to My Account menu
    And click on Login
    And User enters email id "test@gmail.com" and password "test@123"
    And Click on Login button
    Then User navigates to My Account page