!-- ----------------
!-- TTP-17878 - (MBMD) - MYB1- Add To Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch sweden
Given is 'D2C' website for brand 'Siemens' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17878 - (MBMD) - MYB1- Add To Basket
Scenario: TTP-24322 - (MBMD) - MYB1- Add To Basket
GivenStories: localtests/mbmd/steps/TTP-24322.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
