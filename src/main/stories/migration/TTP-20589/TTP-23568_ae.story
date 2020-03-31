!-- ----------------
!-- TTP-23568 - (TEST) Test
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch unitedarabemirates
Given is 'D2C' website for brand 'Bosch' and country 'unitedarabemirates'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23568 - (TEST) Test
Scenario: TTP-23568 - (TEST) Test
GivenStories: migration/TTP-20589/steps/TTP-23568.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
