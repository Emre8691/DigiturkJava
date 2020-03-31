!-- ----------------
!-- TTP-15256 - (MBMD) - MYB2- MyBasket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch sweden
Given is 'D2C' website for brand 'Bosch' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-15256 - (MBMD) - MYB2- MyBasket
Scenario: TTP-15256 - (MBMD) - MYB2- MyBasket
GivenStories: migration/TTP-20589/steps/TTP-15256.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
