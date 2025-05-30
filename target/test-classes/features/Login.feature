Feature: Successful login to Swag Labs

@Positive
Scenario: User should be able to login to Swag Labs

Given User is in Swag Labs login page
When User enters "<username>" and "<password>"
And Click on Login Button
Then User should be able to login successfully

Examples:
| username | password |
| standard_user | secret_sauce |

@Negative
Scenario: Login should fail with invalid credentials
  Given User is in Swag Labs login page
  When User enters "invalid_user" and "wrong_pass"
  And Click on Login Button
  Then User should see an error message
