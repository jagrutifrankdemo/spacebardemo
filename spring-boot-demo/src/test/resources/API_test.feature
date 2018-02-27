@integration
Feature: API  test
  Scenario: To make sure API are working correctly
    Given I set json body for auth token
    When I do a get call to "/getMax"
    Then the status code is 200
    And I check contain type is "application/json"
    And I check jsonSchema for "UserResponseJsonSchema.json"


   # And response includes the following - this is to check static values
    #  | userName          | test |
     # | numbergamesplayed | 4    |

@unit
Scenario: To make controller are tested
  Given I prepare Mock service
  When I will call method
  Then the status code is 200
  And I check contain type is "application/json"
  And I check jsonSchema for "UserResponseJsonSchema.json"