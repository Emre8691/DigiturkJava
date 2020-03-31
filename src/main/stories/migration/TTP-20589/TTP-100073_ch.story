!-- ----------------
!-- TTP-100063 - (MBMD) - PDP1- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens finland
Given is 'D2C' website for brand 'Siemens' and country 'switzerland' and language 'German'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100073 - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-100073 - (MBMD) - PDP1- Product Images - Product Detail
GivenStories: migration/TTP-20589/steps/TTP-100073.steps
!-- ----------------
!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
