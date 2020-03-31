!-- ----------------
!-- TTP-356 - Automatic: Payment : Installments : Price Calculation on Summary Page
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-356 - Automatic: Payment : Installments : Price Calculation on Summary Page
Scenario: TTP-356 - Automatic: Payment : Installments : Price Calculation on Summary Page
GivenStories: migration/TTP-580/steps/TTP-356.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
