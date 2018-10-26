Feature: Service Page tests

  Scenario: Service Page Interface test
    Given I'm on the Home Page by URL: https://epam.github.io/JDI/index.html
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user icon is displayed on the header
    Then Interface on Home Page contains all needed elements
    When I click on the header Service subcategory
    Then Upper Service drop down opens with all needed options
    When I click on the left Service subcategory
    Then Left Service drop down opens with all needed options

    Given I've navigated to the Different Elements page through the upper Service menu
    Then Interface on Different Elements Page contains all needed elements
    Then The right section of the page is displayed
    Then The left section of the page is displayed
    When I select Water and Wind checkboxes
    Then Checking of Water and Wind will be properly logged
    When I select Selen radio-button
    Then Selecting of Selen radio-button will be properly logged
    When I select Yellow item from the Colors Drop Down menu
    Then Selecting of Yellow drop down menu item will be properly logged
    When I un-select Water and Wind checkboxes
    Then Un-selecting of Water and Wind checboxes will be properly logged

