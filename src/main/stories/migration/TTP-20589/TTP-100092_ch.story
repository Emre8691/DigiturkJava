!-- ----------------
!-- TTP-100092 - (MBMD) - MYB1- Add To Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens Switzerland
Given is 'D2C' website for brand 'Siemens' and country 'switzerland' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100092 - (MBMD) - MYB1- Add To Basket
Scenario: TTP-100092 - (MBMD) - MYB1- Add To Basket
GivenStories: migration/TTP-20589/steps/TTP-100092.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
