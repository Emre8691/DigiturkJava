!-- ----------------
!-- TTP-303 - Automatic:Login Functionality (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'Dutch'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-303 - Automatic:Login Functionality (Bosch)
Scenario: TTP-303 - Automatic:Login Functionality (Bosch)
GivenStories: localtests/myaccount/steps/TTP-303.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
