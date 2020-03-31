!-- ----------------
!-- TTP-100251 -Bosch (MBMD) - Staff- Add To Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'STAFF' website for brand 'Bosch' and country 'germany' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100251 - (MBMD) - Staff- Add To Basket
Scenario: TTP-100251 - Bosch - (MBMD) - Add To Basket
GivenStories: migration/TTP-20589/steps/TTP-100251.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
