!-- ----------------
!-- TTP-100265 - Bosch - (MBMD) - Staff- new User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch finland
Given is 'STAFF' website for brand 'Bosch' and country 'finland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
!-- Given http authentication is provided



!-- ----------------
!-- TTP-100265 - Bosch - (MBMD) - Staff - new User Registration
Scenario: TTP-100265 - Bosch - (MBMD) - Staff- new User Registration
GivenStories: migration/TTP-20589/steps/TTP-100265.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
