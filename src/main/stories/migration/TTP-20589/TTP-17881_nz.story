!-- ----------------
!-- TTP-17881 - (MBMD) - SER1- Customer Service - Flyout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch newzealand
Given is 'D2C' website for brand 'Bosch' and country 'newzealand'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17881 - (MBMD) - SER1- Customer Service - Flyout
Scenario: TTP-17881 - (MBMD) - SER1- Customer Service - Flyout
GivenStories: migration/TTP-20589/steps/TTP-17881.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
