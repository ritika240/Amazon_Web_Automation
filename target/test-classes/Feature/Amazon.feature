@AmazonFinal1
Feature: Amazon Automation

  Scenario: Perform Amazon Shopping Flow
  
  	Given open the chrome driver
    Given user opens the Amazon website
    #When user signs up with a new account
    And user logs in and searches for HP laptop
    And user clicks on 'sort by' option and selects one option
    And user opens the 1st link in a new tab
    And user goes back to the parent window and opens the 5th link
    And user adds the product into the cart
    And user verifies product details and price
    Then user goes to the checkout screen