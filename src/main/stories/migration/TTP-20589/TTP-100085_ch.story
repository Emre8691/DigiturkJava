!-- ----------------
!-- TTP-100085 - Siemens - (MBMD) - RES1- new User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS denmark
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100085 - Siemens - (MBMD) - RES1- new User Registration
Scenario: TTP-100085 - Siemens - (MBMD) - RES1- new User Registration
GivenStories: migration/TTP-20589/steps/TTP-100085.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
