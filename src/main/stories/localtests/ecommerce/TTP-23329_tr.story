!-- ----------------
!-- TTP-23329 - PROFILO - Hybris-D2C : Staff Sales Goods : YKB WORLD
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'D2C' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23329 - PROFILO - Hybris-D2C : Staff Sales Goods : YKB WORLD
Scenario: TTP-23329 - PROFILO - Hybris-D2C : Staff Sales Goods : YKB WORLD
GivenStories: localtests/ecommerce/steps/TTP-23329.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
