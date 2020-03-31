!-- ----------------
!-- TTP-100163 - Bosch - (MBMD) - Staff- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch spain
Given is 'STAFF' website for brand 'Bosch' and country 'spain' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100163 - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-100163 - (MBMD) - PDP1- Product Images - Product Detail
GivenStories: migration/TTP-20589/steps/TTP-100163.steps
!-- ----------------
!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
