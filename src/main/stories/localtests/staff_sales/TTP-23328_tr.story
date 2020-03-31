!-- ----------------
!-- TTP-23328 - SIEMENS - Hybris-D2C : Staff Sales Goods : YKB WORLD
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'STAFF' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23328 - SIEMENS - Hybris-D2C : Staff Sales Goods : YKB WORLD
Scenario: TTP-23328 - SIEMENS - Hybris-D2C : Staff Sales Goods : YKB WORLD
GivenStories: localtests/staff_sales/steps/TTP-23328.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
