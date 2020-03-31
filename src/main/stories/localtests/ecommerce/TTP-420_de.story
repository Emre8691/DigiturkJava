!-- ----------------
!-- TTP-420 - Automatic: CEW: Overview Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-420 - Automatic: CEW: Overview Data
Scenario: TTP-420 - Automatic: CEW: Overview Data
GivenStories: localtests/ecommerce/steps/TTP-420.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
