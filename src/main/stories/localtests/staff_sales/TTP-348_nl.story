!-- ----------------
!-- TTP-348 - Automatic: Staffsales MyBasket - Basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-348 - Automatic: Staffsales MyBasket - Basket
Scenario: TTP-348 - Automatic: Staffsales MyBasket - Basket
GivenStories: localtests/staff_sales/steps/TTP-348.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
