!-- ----------------
!-- TTP-349 - Automatic: D2C - N2 myAccount integration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-349 - Automatic: D2C - N2 myAccount integration
Scenario: TTP-349 - Automatic: D2C - N2 myAccount integration
GivenStories: localtests/myaccount/steps/TTP-349.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
