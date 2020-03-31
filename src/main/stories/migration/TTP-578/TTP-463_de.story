!-- ----------------
!-- TTP-463 - Automatic: Checkout with login (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-463 - Automatic: Checkout with login (NEFF)
Scenario: TTP-463 - Automatic: Checkout with login (NEFF)
GivenStories: migration/TTP-578/steps/TTP-463.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
