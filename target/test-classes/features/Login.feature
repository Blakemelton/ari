Feature: Login validation

  Background:
    Given user has entered correct Agency Code

  @smoke
  Scenario Outline: valid username and valid password
    When user enters valid "<username>" and "<password>" and clicks on login and verify the "<sidebarOptions>"
    Examples:
      |username|password|sidebarOptions|
      |QAAdminRole@arch.com   |Q@adm!nR0l3uijkhn9   |16|
      |QAOwnerRole@arch.com  |QA0wner5ol3dfgkjone|12 |
      |QAUserRole@arch.com  |QAU5ErR0lenwo8jf*6m  |10|



  @smoke
  Scenario Outline: valid username and invalid password
    When user enters invalid "<username>" and "<password>" and clicks on login and verify the "<errorMessage>"
    Examples:
      |username|password|errorMessage|
      |incorrectUsername   |Q@adm!nR0l3uijkhn9   |There was a problem. Please verify your username and password and try again. If the problem persists, please contact us for assistance.|
      |QAAdminRole@arch.com  |incorrectPassword|There was a problem. Please verify your username and password and try again. If the problem persists, please contact us for assistance.|


  @smoke
  Scenario Outline: valid username missing password and missing username and valid password
    When user enters invalid "<username>" or "<password>" and clicks on login and verify the "<errorMessage>"
    Examples:
      |username|password|errorMessage|
      |QAAdminRole@arch.com   |           |Password enter your password|
      |   |Q@adm!nR0l3uijkhn9   |Please enter your username|


