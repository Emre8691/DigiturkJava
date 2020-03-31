!-- ----------------
!-- TTP-100077 - (MBMD) - Siemens - Dealor Locator
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS finland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'Italian'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100077 - (MBMD) - Siemens - Dealor Locator
Scenario: TTP-100077 - (MBMD) - Siemens - Dealor Locator
GivenStories: migration/TTP-20589/steps/TTP-100077.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
