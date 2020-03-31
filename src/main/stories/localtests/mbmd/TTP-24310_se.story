!-- ----------------
!-- TTP-24310 - (MBMD) - CHE4- Checkout Register a New User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens sweden
Given is 'D2C' website for brand 'Siemens' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17894 - (MBMD) - CHE4- Checkout Register a New User
Scenario: TTP-24310 - (MBMD) - CHE4- Checkout Register a New User
GivenStories: localtests/mbmd/steps/TTP-24310.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
