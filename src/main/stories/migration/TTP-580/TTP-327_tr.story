!-- ----------------
!-- TTP-327 - Automatic:Payment : Installments : YKB WORLD
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-327 - Automatic:Payment : Installments : YKB WORLD
Scenario: TTP-327 - Automatic:Payment : Installments : YKB WORLD
GivenStories: migration/TTP-580/steps/TTP-327.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
