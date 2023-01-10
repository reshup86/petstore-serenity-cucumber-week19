Feature: Testing pet features on swagger application
  As a user I would like to verify individual endpoint of the pet application

  Scenario: I created a new pet and verify if the pet is added on the application
    When I create new pet by providing the information category "<category>" name "<name>" photoUrls "<photoUrls>" tags "<tags>" status "<status>"
    Then I verify that the pet is created with status 200

  Scenario: I verify the pet was added successfully
    When I get a new pet with petId
    Then I verify that the pet is created

  Scenario: I update the new created pet from the application
    When I update pet with status
    Then  I verify that pet is updated

  Scenario: I delete created pet from the application
    When I delete pet that created
    Then I verify pet is deleted
