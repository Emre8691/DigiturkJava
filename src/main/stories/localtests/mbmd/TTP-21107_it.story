!-- ----------------
!-- TTP-21107 - Neff/Balay - (MBMD) - CHE3- Checkout with Login
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay italy
Given is 'D2C' website for brand 'Balay' and country 'italy'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21107 - Neff/Balay - (MBMD) - CHE3- Checkout with Login
Scenario: TTP-21107 - Neff/Balay - (MBMD) - CHE3- Checkout with Login
GivenStories: localtests/mbmd/steps/TTP-21107.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
