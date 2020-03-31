!-- ----------------
!-- TTP-465 - Automatic: Checkout with logged in (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-465 - Automatic: Checkout with logged in (NEFF)
Scenario: TTP-465 - Automatic: Checkout with logged in (NEFF)
GivenStories: migration/TTP-578/steps/TTP-465.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
