!-- ----------------
!-- TTP-425 - Automatic: Category Flyout (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-425 - Automatic: Category Flyout (NEFF)
Scenario: TTP-425 - Automatic: Category Flyout (NEFF)
GivenStories: migration/TTP-645/steps/TTP-425.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
