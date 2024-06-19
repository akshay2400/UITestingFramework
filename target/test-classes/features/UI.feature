@HomePage
Feature: Searching items
 User wants to search for valid and invalid items

  @positive
   Scenario Outline: User wants to search for valid items
    Given User is already on "https://www.mydesignation.com/" site
    When User clicks search item button
    And User enters "<item>" as search string
    Then Validate if the site is showing "<message>".

    Examples: 
      | item    |						 message 			    	  |
      | Dragon  |     RESULTS FOUND FOR “DRAGON”  |
      | theyyam |     RESULTS FOUND FOR “THEYYAM” |
      | couple  |     RESULTS FOUND FOR “COUPLE”  |


  @negative
 	Scenario Outline: User wants to search for invalid items
    Given User is already on "https://www.mydesignation.com/" site
    When User clicks search item button
    And User enters "<item>" as search string
    Then Validate if the site is error message as "<message>".

   Examples: 
      | item    |			  message 		    |
      | qwerty  |     No results found  |
      | poasnwk |     No results found 	|
      | wefwkj  |     No results found  |
