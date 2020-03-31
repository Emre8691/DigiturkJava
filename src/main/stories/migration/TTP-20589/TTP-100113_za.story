!-- ----------------
!-- TTP-100113 - (MBMD) - PDP1- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens southafrica
Given is 'D2C' website for brand 'SIEMENS' and country 'southafrica' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100113 - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-100113 - (MBMD) - PDP1- Product Images - Product Detail
GivenStories: migration/TTP-20589/steps/TTP-100113.steps
!-- ----------------
!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
