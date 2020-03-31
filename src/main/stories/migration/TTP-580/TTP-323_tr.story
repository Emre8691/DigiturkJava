!-- ----------------
!-- TTP-323 - Automatic: Payment : Installments : Turkish Terms and Conditions
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-323 - Automatic: Payment : Installments : Turkish Terms and Conditions
Scenario: TTP-323 - Automatic: Payment : Installments : Turkish Terms and Conditions
GivenStories: migration/TTP-580/steps/TTP-323.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
