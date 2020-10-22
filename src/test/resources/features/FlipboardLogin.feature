@LoginFeature
Feature: Login Feature
  In order to perform successul login
  As a User
  I want to launch the Flipboard app and perform login

  Scenario Outline: In order to verify login to flipboard app
    Given user clicks on getStartedButton
    When user selects <topicCount> topics
    Then user clicks on continue button

    Examples: 
      | topicCount |
      |          3 |
      |          4 |
