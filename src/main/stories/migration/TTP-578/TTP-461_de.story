!-- ----------------
!-- TTP-461 - Automatic. Add to basket (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-461 - Automatic. Add to basket (NEFF)
Scenario: TTP-461 - Automatic. Add to basket (NEFF)
GivenStories: migration/TTP-578/steps/TTP-461.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
