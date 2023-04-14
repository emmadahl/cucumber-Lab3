Feature: Test Lab3SVTPlay

  Scenario: SVT Play should show correct title
    Given SVT Play is available
    When User visits SVT Play
    Then Title should be "SVT Play"

  Scenario: SVT Play logo should be visible
    Given SVT Play is available
    When User visits SVT Play
    Then Logotype should be visible

  Scenario: Start menu should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Start menu text should be "START"

  Scenario: Program menu should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Program menu text should be "PROGRAM"

  Scenario: Chanel menu should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Chanel menu text should be "KANALER"

  Scenario:  Availability link should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Availability link text should be "Tillgänglighet i SVT Play"

 Scenario: Should show correct heading
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on availability link
   Then Heading should be "Så arbetar SVT med tillgänglighet"

 Scenario: Number of categories should be correct
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on program link
   Then Number of categories should be correct

  Scenario: Heading text should be correct
    Given SVT Play is available
    When User visits SVT Play
    When User clicks on chanels link
    Then Heading text should be "På SVT just nu"

 Scenario: Check newsletter link text
   Given SVT Play is available
   When User visits SVT Play
   Then Link text should be "Nyhetsbrev"

 Scenario: Newsletter page logotype should be visible
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on newsletter
   Then Logotype on page should be visible

 Scenario: Error message when writing an invalid email should be correct
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on newsletter
   When User is writing an invalid email adress
   Then The error message should be "Du måste ange en giltig e-postaddress!"

 Scenario: Terms checkbox should not be selected
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on newsletter
   Then The terms checkbox should not be selected

 Scenario: Should show correct error message when search does not match
   Given SVT Play is available
   When User visits SVT Play
   When User is writing a search does not have a match
   Then Should show error message "Det kan vara så att du sökt efter ett program vi inte visar just nu."

 Scenario: Should show correct error message when user does not enter any value
   Given SVT Play is available
   When User visits SVT Play
   When User writes no value in search field
   Then Correct error message should be "Du behöver ange något att söka efter."

 Scenario: After correct search text should be displayed
   Given SVT Play is available
   When User visits SVT Play
   When User writes a valid value in search field
   Then Search result should be "Agenda"

 Scenario: Button text should be correct
   Given SVT Play is available
   When User visits SVT Play
   When User writes a valid value in search field
   When User clicks on Agenda link
   Then Button should show text "VISA FLER"

 Scenario: Aria label should be displayed
   Given SVT Play is available
   When User visits SVT Play
   Then Aria label should be displayed

 Scenario: Serier text should be correct
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on program link
   Then Text should be "Serier"

 Scenario: When clicking on specific category correct text should be visible
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on program link
   When User clicks on category link
   Then Correct text should be displayed

 Scenario: Settings link should be visible
   Given SVT Play is available
   When User visits SVT Play
   Then Settings link should be visible