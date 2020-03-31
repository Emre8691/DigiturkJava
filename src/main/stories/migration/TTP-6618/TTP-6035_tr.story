!-- ----------------
!-- TTP-6035 - [Prod] - Category based Add a Product to Basket form every category listed - BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-6035 - [Prod] - Category based Add a Product to Basket form every category listed - BOSCH-TR
Scenario: TTP-6035 - [Prod] - Category based Add a Product to Basket form every category listed - BOSCH-TR
GivenStories: migration/TTP-6618/steps/TTP-6035.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
