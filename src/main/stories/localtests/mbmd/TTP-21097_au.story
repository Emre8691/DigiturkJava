!-- ----------------
!-- TTP-21097 - Neff/Balay - (MBMD) - MYB1- Add To Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay australia
Given is 'D2C' website for brand 'Balay' and country 'australia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21097 - Neff/Balay - (MBMD) - MYB1- Add To Basket
Scenario: TTP-21097 - Neff/Balay - (MBMD) - MYB1- Add To Basket
GivenStories: localtests/mbmd/steps/TTP-21097.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
