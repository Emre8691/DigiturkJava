!-- ----------------
!-- TTP-22761 - test of test
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch italy
Given is 'D2C' website for brand 'Bosch' and country 'italy'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-22761 - test of test
Scenario: TTP-22761 - test of test
GivenStories: migration/TTP-20589/steps/TTP-22761.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
