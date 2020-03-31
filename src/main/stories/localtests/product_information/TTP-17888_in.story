!-- ----------------
!-- TTP-17888 - (MBMD) - PDP1- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch india
Given is 'D2C' website for brand 'Bosch' and country 'india'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17888 - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-17888 - (MBMD) - PDP1- Product Images - Product Detail
GivenStories: localtests/product_information/steps/TTP-17888.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
