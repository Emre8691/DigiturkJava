!-- ----------------
!-- TTP-15254 - (MBMD) - Flyout Navigation
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch austria
Given is 'D2C' website for brand 'Bosch' and country 'austria'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-15254 - (MBMD) - Flyout Navigation
Scenario: TTP-15254 - (MBMD) - Flyout Navigation
GivenStories: localtests/mbmd/steps/TTP-15254.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
