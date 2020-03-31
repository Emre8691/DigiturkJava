!-- ----------------
!-- TTP-100292 - Bosch - (MBMD) - Staff- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch norway
Given is 'STAFF' website for brand 'Bosch' and country 'norway'  
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100292 - Bosch - (MBMD) - Staff - Product Images - Product Detail
Scenario: TTP-100292 - Bosch - (MBMD) - Product Images - Product Detail
GivenStories: migration/TTP-20589/steps/TTP-100292.steps
!-- ----------------
!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
