!-- ----------------
!-- TTP-387 - Automatic:Dealer Locator:Find Dealer via Product Detail Page
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-387 - Automatic:Dealer Locator:Find Dealer via Product Detail Page
Scenario: TTP-387 - Automatic:Dealer Locator:Find Dealer via Product Detail Page
GivenStories: localtests/dealer_locator/steps/TTP-387.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
