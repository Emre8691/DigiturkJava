!-- ----------------
!-- TTP-23300 - Dummy Test for HMC D2C 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch sweden
Given is 'D2C' website for brand 'Bosch' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23300 - Dummy Test for HMC D2C 
Scenario: TTP-23300 - Dummy Test for HMC D2C 
GivenStories: migration/TTP-20589/steps/TTP-23300.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
