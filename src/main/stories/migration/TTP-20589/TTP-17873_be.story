!-- ----------------
!-- TTP-17873 - (MBMD) - BAS1 - Carousel Shop
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch belgium
Given is 'D2C' website for brand 'Bosch' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17873 - (MBMD) - BAS1 - Carousel Shop
Scenario: TTP-17873 - (MBMD) - BAS1 - Carousel Shop
GivenStories: migration/TTP-20589/steps/TTP-17873.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
