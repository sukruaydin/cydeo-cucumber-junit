Feature: Task


  Scenario: Google page
    Then User sees favorite "banana"
    Then User eats favorite fruits
      | strawberry |
      | kiwi       |
      | cucumber   |

  @wip
  Scenario Outline: Fleet Management
    Given "<driver>" opens the app
    Given "<boss>" opens the apps
    Examples:
      | driver | boss   |
      | musti  | oğuz   |
      | şükrü  | yüksel |







