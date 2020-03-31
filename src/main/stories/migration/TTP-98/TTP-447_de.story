!-- ----------------
!-- TTP-447 - Automatic: Password forgotten (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-447 - Automatic: Password forgotten (NEFF)
Scenario: TTP-447 - Automatic: Password forgotten (NEFF)
GivenStories: migration/TTP-98/steps/TTP-447.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
