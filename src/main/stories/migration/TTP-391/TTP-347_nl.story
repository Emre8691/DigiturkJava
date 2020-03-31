!-- ----------------
!-- TTP-347 - Automatic: Staffsales MyBasket - Add to basket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-347 - Automatic: Staffsales MyBasket - Add to basket
Scenario: TTP-347 - Automatic: Staffsales MyBasket - Add to basket
GivenStories: migration/TTP-391/steps/TTP-347.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
