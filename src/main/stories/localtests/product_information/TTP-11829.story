!-- ----------------
!-- TTP-11829 - PI - Marketing Product Detail Page - Campaign Icons
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11829 - PI - Marketing Product Detail Page - Campaign Icons
Scenario: TTP-11829 - PI - Marketing Product Detail Page - Campaign Icons
GivenStories: localtests/product_information/steps/TTP-11829.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
