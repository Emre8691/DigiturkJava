!-- ----------------
!-- TTP-326 - Automatic: Payment : Installments - Garanti BONUS
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-326 - Automatic: Payment : Installments - Garanti BONUS
Scenario: TTP-326 - Automatic: Payment : Installments - Garanti BONUS
GivenStories: migration/TTP-580/steps/TTP-326.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
