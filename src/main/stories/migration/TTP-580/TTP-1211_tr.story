!-- ----------------
!-- TTP-1211 - Automatic: Checkout with IsBank - Bosch TR public
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1211 - Automatic: Checkout with IsBank - Bosch TR public
Scenario: TTP-1211 - Automatic: Checkout with IsBank - Bosch TR public
GivenStories: migration/TTP-580/steps/TTP-1211.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
