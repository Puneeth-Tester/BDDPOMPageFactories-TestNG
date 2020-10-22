@ZFailFeature
Feature: ZFail the Feature
  
  Scenario Outline: In order to zfail the scenario
    Given user clicks on getStartedButton
    When user selects <topicCount> topics
    Then user fails the test
    
    Examples: 
      | topicCount | 
      |          3 |