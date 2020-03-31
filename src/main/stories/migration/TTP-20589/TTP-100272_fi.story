!-- ----------------
!-- TTP-100272 - Bosch - (MBMD) - Staff- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch finland
Given is 'STAFF' website for brand 'Bosch' and country 'finland'  
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100272 - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-100272 - Bosch - (MBMD) - Product Images - Product Detail
GivenStories: migration/TTP-20589/steps/TTP-100272.steps
!-- ----------------
!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
