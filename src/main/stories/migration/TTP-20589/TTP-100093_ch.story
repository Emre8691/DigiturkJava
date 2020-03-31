!-- ----------------
!-- TTP-100093 - (MBMD) - PDP1- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens finland
Given is 'D2C' website for brand 'Siemens' and country 'switzerland' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100093 - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-100093 - (MBMD) - PDP1- Product Images - Product Detail
GivenStories: migration/TTP-20589/steps/TTP-100093.steps
!-- ----------------
!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
