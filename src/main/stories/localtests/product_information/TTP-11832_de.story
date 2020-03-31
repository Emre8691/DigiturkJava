!-- ----------------
!-- TTP-11832 - PI - Marketing Product Detail Page - Dealer Locator
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11832 - PI - Marketing Product Detail Page - Dealer Locator
Scenario: TTP-11832 - PI - Marketing Product Detail Page - Dealer Locator
GivenStories: localtests/product_information/steps/TTP-11832.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
