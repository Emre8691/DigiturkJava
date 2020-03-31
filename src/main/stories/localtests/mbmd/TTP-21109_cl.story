!-- ----------------
!-- TTP-21109 - Neff/Balay - (MBMD) - SER1- Customer Service - Flyout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff chile
Given is 'D2C' website for brand 'Neff' and country 'chile'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21109 - Neff/Balay - (MBMD) - SER1- Customer Service - Flyout
Scenario: TTP-21109 - Neff/Balay - (MBMD) - SER1- Customer Service - Flyout
GivenStories: localtests/mbmd/steps/TTP-21109.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
