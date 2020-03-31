!-- ----------------
!-- TTP-17895 - (MBMD) - RES1- new User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens sweden
Given is 'D2C' website for brand 'Siemens' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17895 - (MBMD) - RES1- new User Registration
Scenario: TTP-24311 - (MBMD) - RES1- new User Registration
GivenStories: localtests/mbmd/steps/TTP-24311.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
