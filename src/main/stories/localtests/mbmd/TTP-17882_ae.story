!-- ----------------
!-- TTP-17882 - (MBMD) - CHE1- Checkout Logged User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch unitedarabemirates
Given is 'D2C' website for brand 'Bosch' and country 'unitedarabemirates'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17882 - (MBMD) - CHE1- Checkout Logged User
Scenario: TTP-17882 - (MBMD) - CHE1- Checkout Logged User
GivenStories: localtests/mbmd/steps/TTP-17882.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
