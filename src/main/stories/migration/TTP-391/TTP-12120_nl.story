!-- ----------------
!-- TTP-12120 - BGoods Outlet Bosch NL -1- product purchase with MasterCard
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'STAFF' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-12120 - BGoods Outlet Bosch NL -1- product purchase with MasterCard
Scenario: TTP-12120 - BGoods Outlet Bosch NL -1- product purchase with MasterCard
GivenStories: migration/TTP-391/steps/TTP-12120.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
