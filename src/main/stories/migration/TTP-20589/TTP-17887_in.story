!-- ----------------
!-- TTP-17887 - (MBMD) - LOC2- Dealer Locator - Plan Route
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch india
Given is 'D2C' website for brand 'Bosch' and country 'india'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17887 - (MBMD) - LOC2- Dealer Locator - Plan Route
Scenario: TTP-17887 - (MBMD) - LOC2- Dealer Locator - Plan Route
GivenStories: migration/TTP-20589/steps/TTP-17887.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
