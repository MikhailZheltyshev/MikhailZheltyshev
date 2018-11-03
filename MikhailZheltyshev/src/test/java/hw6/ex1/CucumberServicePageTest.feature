Feature: Service Page tests

  Scenario: Service Page Interface test
    Given I am on "Home Page"
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user icon PITER CHAILOVSKII is displayed on the header
    Then Interface on Home Page contains all needed elements
    When I click on "Service" button in Header
    Then Upper Service drop down opens with all needed options
    When I click on the left Service subcategory
    Then Left Service drop down opens with all needed options
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    Then "Different Elements" page is opened
    Then Interface on Different Elements Page contains all needed elements
    Then The right section of the page is displayed
    Then The left section of the page is displayed
    When I select checkboxes:
      | Water |
      | Wind  |
    Then Checking of following checkboxes will be properly logged:
      | Water |
      | Wind  |
    When I select Selen radio-button
    Then Selecting of Selen radio-button will be properly logged
    When I select Yellow item from the Colors Drop Down menu
    Then Selecting of Yellow drop down menu item will be properly logged
    When I un-select checkboxes:
      | Water |
      | Wind  |
    Then Un-selecting of following checboxes will be properly logged:
      | Water |
      | Wind  |

