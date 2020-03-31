!-- ----------------
!-- TTP-357 - Automatic: Dealer Locator: Find Dealer (A)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-357 - Automatic: Dealer Locator: Find Dealer (A)
Scenario: TTP-357 - Automatic: Dealer Locator: Find Dealer (A)
GivenStories: localtests/dealer_locator/steps/TTP-357.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
