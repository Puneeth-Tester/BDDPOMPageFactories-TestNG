@SearchItem
Feature: Search Item Feature
  In order to perform successul Search
  As a User
  I want to launch the Flipboard app and perform login and search Items

  Scenario Outline: In order to Search Items flipboard app
    Given user clicks on getStartedButton
    When user selects <topicCount> topics
    Then user clicks on continue button
    And user clicks on skip for now button
    And user clicks on search panel
    And user enters the <searchText>

    Examples: 
      | topicCount | searchText |
      |          3 | airpods    |
