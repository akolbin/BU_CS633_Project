@Automation
Feature: Hotel Management System feature file

Scenario: To check navigation from Homepage to About Us page
	Given I am on homepage
	When I click on About us link
	Then I should be navigated to About us Page
	
Scenario: To check navigation from Homepage to Rooms Page
	Given I am on homepage
	When I click on Rooms link
	Then I should be navigated to Rooms Page

Scenario: To check navigation from Homepage to Activities Page
	Given I am on homepage
	When I click on Activities link
	Then I should be navigated to Activities Page

Scenario: To check navigation from Homepage to Contact Page
	Given I am on homepage
	When I click on Contact link
	Then I should be navigated to Contact Page

Scenario: To check navigation from Book Now button to Rooms Page
	Given I am on homepage
	When I click on Book Now Button
	Then I should be navigated to Rooms Page