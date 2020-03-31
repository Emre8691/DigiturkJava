!-- ----------------
!-- TTP-20564 - (MBMD) - ACC1- Login
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch russia
Given is 'D2C' website for brand 'Bosch' and country 'russia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-20564 - (MBMD) - ACC1- Login
Scenario: TTP-20564 - (MBMD) - ACC1- Login
GivenStories: migration/TTP-649/steps/TTP-20564.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
