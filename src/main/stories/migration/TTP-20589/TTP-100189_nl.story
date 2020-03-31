!-- ----------------
!-- TTP-100189 - (MBMD) - CHE3- Checkout with Login
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'STAFF' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100189 - (MBMD) - CHE3- Checkout with Login
Scenario: TTP-100189 - (MBMD) - CHE3- Checkout with Login
GivenStories: migration/TTP-20589/steps/TTP-100189.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
