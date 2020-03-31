!-- ----------------
!-- TTP-100221 -Bosch (MBMD) - Staff- Add To Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch Belgium
Given is 'STAFF' website for brand 'Bosch' and country 'belgium' and language 'Dutch' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100221 - (MBMD) - Staff- Add To Basket
Scenario: TTP-100221 - (MBMD) - MYB1- Add To Basket
GivenStories: migration/TTP-20589/steps/TTP-100221.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
