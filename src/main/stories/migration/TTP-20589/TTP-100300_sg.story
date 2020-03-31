!-- ----------------
!-- TTP-100300 - Bosch - (MBMD) - D2C - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch singapore
Given is 'D2C' website for brand 'Bosch' and country 'singapore' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100300 - Bosch - (MBMD) - D2C - MyAccount - Password Forgotten
Scenario: TTP-100300 - Bosch - (MBMD) - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-100300.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
