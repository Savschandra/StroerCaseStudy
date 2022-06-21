Feature: Stroer Case Study

  Background:
    When User navigates to web shop URL

    #This is the actual test case file return in gherkin language

  @Requirement1
  Scenario: Test01 >> verify user is able login to webShop
    Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    Then User should get successful login message
    Then User navigates to webShop home page

  @Requirement1
  Scenario: Test02 >> verify user is not able to login to webShop with wrong user details
    Given Load second Test Data from "<Case_2>"
    When User enters invalid credentials
    And User clicks on Login button
    Then User should get error message
    Then User should remain on login page

  @Requirement1
  Scenario: Test03 >> verify user is able to add product to cart
    Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    When User navigates to webShop home page
    Then User checks product name, product price and description
    When User clicks on add to cart button
    Then product is added to cart

  @Requirement1
  Scenario: Test04 >> verify checkout page
    Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    When User navigates to webShop home page
    When User clicks on add to cart button
    Then product is added to cart
    When user clicks on cart button
    Then user navigates to checkout page
    Then User checks his details and product in cart
    When user clicks on checkout button
    Then user gets success message

 @Requirement2
  Scenario: Test05 >> Verify order tables
   Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    When User clicks on add to cart button
    And user clicks on cart button
    And user clicks on checkout button
    Then Order table is created
    And User verifies table data


  @Requirement3
  Scenario: Test06 >> Verify confirmation email is sent to Customer
    Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    When User clicks on add to cart button
    And user clicks on cart button
    And user clicks on checkout button
    Then verify confirmation email is sent to customer

  @Requirement4
  Scenario: Test07 >> Verify order xml is created
    Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    When User clicks on add to cart button
    And user clicks on cart button
    And user clicks on checkout button
    Then verify order xml is created

  @Requirement4
  Scenario: Test08 >> Verify product details in order xml
    Given Load Test Data from "<Case_1>"
    When User enters valid credentials
    And User clicks on Login button
    When User clicks on add to cart button
    And user clicks on cart button
    And user clicks on checkout button
    And read created order xml
    Then User can verify product details <Product ID> in xml

#  @AnotherApproach
#  Scenario Outline: Test04 >> Verify login action with multiple users
#    Then User enters valid "<username>" and "<password>"
#    And User clicks on Login button
#    Then User clicks on logout
#    Examples:
#      | username | password |
#      |abc       | 1234     |
#      |def       | 5678     |
