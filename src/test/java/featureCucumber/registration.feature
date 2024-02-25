Feature: Register and Change Password
  As a user
  I want to register on the website
  So that I can upload a profile picture and change my password

  Scenario: Register, Upload Profile Picture, and Change Password
    Given I am on the home page
    When I register with valid details
    And I upload a profile picture
    And I change my password
    Then I cannot login with the old password