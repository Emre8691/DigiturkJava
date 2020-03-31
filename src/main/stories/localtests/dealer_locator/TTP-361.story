!-- ----------------
!-- TTP-361 - Automatic: Dealer Locator: Find Dealer (B)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-361 - Automatic: Dealer Locator: Find Dealer (B)
Scenario: TTP-361 - Automatic: Dealer Locator: Find Dealer (B)
GivenStories: localtests/dealer_locator/steps/TTP-361.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
