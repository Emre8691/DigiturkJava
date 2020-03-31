!-- ----------------
!-- TTP-24323 - (MBMD) - CHE1- Checkout Logged User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens sweden
Given is 'D2C' website for brand 'Siemens' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-24323 - (MBMD) - CHE1- Checkout Logged User
Scenario: TTP-24323 - (MBMD) - CHE1- Checkout Logged User
GivenStories: localtests/mbmd/steps/TTP-24323.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
