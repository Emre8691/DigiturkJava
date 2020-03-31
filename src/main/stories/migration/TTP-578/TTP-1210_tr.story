!-- ----------------
!-- TTP-1210 - Automatic: Max order limit per item in one order
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1210 - Automatic: Max order limit per item in one order
Scenario: TTP-1210 - Automatic: Max order limit per item in one order
GivenStories: migration/TTP-578/steps/TTP-1210.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
