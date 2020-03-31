!-- ----------------
!-- TTP-12122 - BGoods Outlet Bosch NL -2- AddToBasket BGood product
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'STAFF' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-12122 - BGoods Outlet Bosch NL -2- AddToBasket BGood product
Scenario: TTP-12122 - BGoods Outlet Bosch NL -2- AddToBasket BGood product
GivenStories: localtests/staff_sales/steps/TTP-12122.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
