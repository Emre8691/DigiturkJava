!-- ----------------
!-- TTP-443 - Automatic: My Products (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-443 - Automatic: My Products (NEFF)
Scenario: TTP-443 - Automatic: My Products (NEFF)
GivenStories: migration/TTP-635/steps/TTP-443.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
