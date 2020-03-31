!-- ----------------
!-- TTP-12123 - BGoods Outlet Bosch NL -3- BGood product search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'STAFF' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-12123 - BGoods Outlet Bosch NL -3- BGood product search
Scenario: TTP-12123 - BGoods Outlet Bosch NL -3- BGood product search
GivenStories: localtests/staff_sales/steps/TTP-12123.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
