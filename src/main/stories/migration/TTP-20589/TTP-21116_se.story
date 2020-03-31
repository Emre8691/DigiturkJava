!-- ----------------
!-- TTP-21116 - Neff/Balay - (MBMD) - LOC2- Dealer Locator - Plan Route
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay sweden
Given is 'D2C' website for brand 'Balay' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21116 - Neff/Balay - (MBMD) - LOC2- Dealer Locator - Plan Route
Scenario: TTP-21116 - Neff/Balay - (MBMD) - LOC2- Dealer Locator - Plan Route
GivenStories: migration/TTP-20589/steps/TTP-21116.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
