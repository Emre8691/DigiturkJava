!-- ----------------
!-- TTP-21116 - Neff/Balay - (MBMD) - LOC2- Dealer Locator - Plan Route
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay australia
Given is 'D2C' website for brand 'Balay' and country 'australia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21116 - Neff/Balay - (MBMD) - LOC2- Dealer Locator - Plan Route
Scenario: TTP-21116 - Neff/Balay - (MBMD) - LOC2- Dealer Locator - Plan Route
GivenStories: localtests/mbmd/steps/TTP-21116.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
