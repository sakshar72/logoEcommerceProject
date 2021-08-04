Feature: Reorder journey
Scenario: User is able to place the reorder successfully
	Given Open the home page URL 
	Then Click on Sign In button 
	Then User Enter the Login credentials 
	Then Click on SignIn Button 
	Then Verfiy the details
	Then click on order history link
	Then capture the order refrence id, price and payment method
	Then click on reorder link
	Then change the quantity value
	Then verify whether quantity increased and price of product changed
	