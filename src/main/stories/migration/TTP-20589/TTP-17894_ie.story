!-- ----------------
!-- TTP-17894 - (MBMD) - CHE4- Checkout Register a New User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch ireland
Given is 'D2C' website for brand 'Bosch' and country 'ireland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17894 - (MBMD) - CHE4- Checkout Register a New User
Scenario: TTP-17894 - (MBMD) - CHE4- Checkout Register a New User
GivenStories: migration/TTP-20589/steps/TTP-17894.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
