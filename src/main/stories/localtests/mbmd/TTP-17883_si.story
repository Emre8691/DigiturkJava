!-- ----------------
!-- TTP-17883 - (MBMD) - CHE2- Checkout Logged User - add new delivery address
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch slovenia
Given is 'D2C' website for brand 'Bosch' and country 'slovenia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17883 - (MBMD) - CHE2- Checkout Logged User - add new delivery address
Scenario: TTP-17883 - (MBMD) - CHE2- Checkout Logged User - add new delivery address
GivenStories: localtests/mbmd/steps/TTP-17883.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
