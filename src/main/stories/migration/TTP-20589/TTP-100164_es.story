!-- ----------------
!-- TTP-100164 - (MBMD) - CHE3- Checkout with Login
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'STAFF' website for brand 'Bosch' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100164 - (MBMD) - CHE3- Checkout with Login
Scenario: TTP-100164 - (MBMD) - CHE3- Checkout with Login
GivenStories: migration/TTP-20589/steps/TTP-100164.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
