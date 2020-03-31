!-- ----------------
!-- TTP-15255 - (BALAY) - Dealer Locator
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay spain
Given is 'D2C' website for brand 'Balay' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-15255 - (BALAY) - Dealer Locator
Scenario: TTP-15255 - (BALAY) - Dealer Locator
GivenStories: migration/TTP-649/steps/TTP-15255.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
