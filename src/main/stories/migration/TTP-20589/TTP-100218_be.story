!-- ----------------
!-- TTP-100218 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch canada
Given is 'STAFF' website for brand 'Bosch' and country 'belgium' and language 'Dutch' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100218 - (MBMD) - Staff - MyAccount - Change MyProfile Personal Data
Scenario: TTP-100218 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
GivenStories: migration/TTP-20589/steps/TTP-100218.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
