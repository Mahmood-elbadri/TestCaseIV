Feature: comparison functionality

  Scenario: Check comparison functionality
    Given Navigate to the site ,Click on mobile menu
    When In mobile product list click add to compare two devices
    And Click compare button, verify the pop-up window
    And check the products reflected on it
    Then close the pop-up window
    
