@room_creation @e2e
Feature: Admin creates room
  Background:
    Given admin goes to "https://medunna.com/" homepage
    And clicks on userIcon
    And clicks on signIn option
    And enters username in the Username field
    And enters password in the Password field
    And clicks on signIn button

  Scenario Outline: Room creation
    When admin clicks Items&Titles button
    And clicks on Room option
    And clicks on Create A New Room button
    And enters roomNumber into Room Number field
    And chooses "DELUXE" from the dropdown
    And clicks Status box
    And enters "<price>" into Price field
    And enters "<description>" into Description field
    And clicks on Save button
    Then verify the new room is created

    Examples:
      | price |description |
      |1400 | SeaView |