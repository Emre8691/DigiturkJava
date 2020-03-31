!-- ----------------
!-- TTP-101 - Automatic:Product Detail Page:Product Images
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-101 - Automatic:Product Detail Page:Product Images
Scenario: TTP-101 - Automatic:Product Detail Page:Product Images
GivenStories: localtests/product_information/steps/TTP-101.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
