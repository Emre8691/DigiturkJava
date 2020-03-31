!-- ----------------
!-- TTP-100155 - Bosch - (MBMD) - RES1- new User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch spain
Given is 'STAFF' website for brand 'Bosch' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
!-- Given http authentication is provided



!-- ----------------
!-- TTP-100155 - Bosch - (MBMD) - RES1- new User Registration
Scenario: TTP-100155 - Bosch - (MBMD) - RES1- new User Registration
GivenStories: migration/TTP-20589/steps/TTP-100155.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
