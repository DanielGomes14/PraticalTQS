Feature: Search in BlazeDemo

  Scenario: Seek for Flights Prices
    When I navigate to 'https://blazedemo.com/'
    And I want to travel from 'Paris' to 'London'
    And I want to my flight from 'Lufthansa'
    And I Enter my Personal Information
    Then The Flight Final Price Should be 555
