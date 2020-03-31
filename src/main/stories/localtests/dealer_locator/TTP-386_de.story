!-- ----------------
!-- TTP-386 - Automatic : Dealer Locator: Plan Route
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-386 - Automatic : Dealer Locator: Plan Route
Scenario: TTP-386 - Automatic : Dealer Locator: Plan Route
GivenStories: localtests/dealer_locator/steps/TTP-386.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
