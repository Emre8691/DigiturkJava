!-- ----------------
!-- TTP-453 - Automatic: Socialmedia Registration (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-453 - Automatic: Socialmedia Registration (NEFF)
Scenario: TTP-453 - Automatic: Socialmedia Registration (NEFF)
GivenStories: localtests/myaccount/steps/TTP-453.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
