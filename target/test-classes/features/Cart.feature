Feature: User should be able to add and remove the products from the cart

Background:
Given User is logged into Swag Labs

Scenario: User should be able to add the product
When User clicks on add to cart for a product
Then Product should be added to the cart

Scenario:User should be able to remove the product
When User clicks on add to cart for a product
And User clicks on remove for a product
Then Product should be remove from the cart