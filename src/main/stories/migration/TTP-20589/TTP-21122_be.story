!-- ----------------
!-- TTP-21122 - Neff/Balay - (MBMD) - CHE2- Checkout Logged User - add new delivery address
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay belgium
Given is 'D2C' website for brand 'Balay' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21122 - Neff/Balay - (MBMD) - CHE2- Checkout Logged User - add new delivery address
Scenario: TTP-21122 - Neff/Balay - (MBMD) - CHE2- Checkout Logged User - add new delivery address
GivenStories: migration/TTP-20589/steps/TTP-21122.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
