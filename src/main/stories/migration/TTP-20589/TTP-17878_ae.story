!-- ----------------
!-- TTP-17878 - (MBMD) - MYB1- Add To Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch unitedarabemirates
Given is 'D2C' website for brand 'Bosch' and country 'unitedarabemirates'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17878 - (MBMD) - MYB1- Add To Basket
Scenario: TTP-17878 - (MBMD) - MYB1- Add To Basket
GivenStories: migration/TTP-20589/steps/TTP-17878.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
