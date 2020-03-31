!-- ----------------
!-- TTP-4941 - Basket: Display of static/dynamic delivery cost message according to threshold BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-4941 - Basket: Display of static/dynamic delivery cost message according to threshold BOSCH-TR
Scenario: TTP-4941 - Basket: Display of static/dynamic delivery cost message according to threshold BOSCH-TR
GivenStories: localtests/ecommerce/steps/TTP-4941.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
