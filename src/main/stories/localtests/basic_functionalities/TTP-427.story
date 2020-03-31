!-- ----------------
!-- TTP-427 - Automatic: Spare Part Search (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-427 - Automatic: Spare Part Search (NEFF)
Scenario: TTP-427 - Automatic: Spare Part Search (NEFF)
GivenStories: localtests/basic_functionalities/steps/TTP-427.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
