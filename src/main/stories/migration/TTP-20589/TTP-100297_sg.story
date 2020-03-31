!-- ----------------
!-- TTP-100297 - (MBMD) - Siemens - Dealor Locator
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch singapore
Given is 'D2C' website for brand 'Bosch' and country 'singapore'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100297 - Bosch - (MBMD) - D2C - Dealor Locator
Scenario: TTP-100297 - (MBMD) - Bosch - Dealor Locator
GivenStories: migration/TTP-20589/steps/TTP-100297.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
