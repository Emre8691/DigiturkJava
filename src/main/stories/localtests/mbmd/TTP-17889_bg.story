!-- ----------------
!-- TTP-17889 - (MBMD) - ACC1- Login
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch bulgaria
Given is 'D2C' website for brand 'Bosch' and country 'bulgaria'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17889 - (MBMD) - ACC1- Login
Scenario: TTP-17889 - (MBMD) - ACC1- Login
GivenStories: localtests/mbmd/steps/TTP-17889.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
