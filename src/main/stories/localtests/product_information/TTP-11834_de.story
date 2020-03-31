!-- ----------------
!-- TTP-11834 - PI - Marketing Product Detail Page - Product Price
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11834 - PI - Marketing Product Detail Page - Product Price
Scenario: TTP-11834 - PI - Marketing Product Detail Page - Product Price
GivenStories: localtests/product_information/steps/TTP-11834.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
