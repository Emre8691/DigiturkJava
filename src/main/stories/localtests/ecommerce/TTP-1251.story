!-- ----------------
!-- TTP-1251 - Siemens Basket: Display of static/dynamic delivery cost message according to threshold
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1251 - Siemens Basket: Display of static/dynamic delivery cost message according to threshold
Scenario: TTP-1251 - Siemens Basket: Display of static/dynamic delivery cost message according to threshold
GivenStories: localtests/ecommerce/steps/TTP-1251.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
