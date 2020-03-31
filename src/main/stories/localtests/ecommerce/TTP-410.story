!-- ----------------
!-- TTP-410 - Automatic: CEW: Tab My Code exists
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-410 - Automatic: CEW: Tab My Code exists
Scenario: TTP-410 - Automatic: CEW: Tab My Code exists
GivenStories: localtests/ecommerce/steps/TTP-410.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
