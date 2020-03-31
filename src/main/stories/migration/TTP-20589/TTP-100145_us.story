!-- ----------------
!-- TTP-100145 - Bosch - (MBMD) - RES1- new User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch usa
Given is 'STAFF' website for brand 'Bosch' and country 'usa'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
!-- Given http authentication is provided



!-- ----------------
!-- TTP-100145 - Bosch - (MBMD) - RES1- new User Registration
Scenario: TTP-100145 - Bosch - (MBMD) - RES1- new User Registration
GivenStories: migration/TTP-20589/steps/TTP-100145.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
