Feature: User should be able to view the product list and product details.

Background:
Given User is in Swag labs website
When User enters valid username and password


Scenario: User be able to view all the products
Then User should be navigated to inventory page
And All products should be displayed

Scenario: User should be able to open the product details by clicking image
When User clicks on product image
Then Product details should be displayed

Scenario: User should be able to view product details by clicking the product title
When User clicks on product title
Then Product details should be displayed
