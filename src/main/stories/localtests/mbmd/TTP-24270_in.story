!-- ----------------
!-- TTP-24270 - (MBMD) - Siemens - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS india
Given is 'D2C' website for brand 'SIEMENS' and country 'india'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-24270 - (MBMD) - Siemens - MyAccount - Password Forgotten
Scenario: TTP-24270 - (MBMD) - Siemens - MyAccount - Password Forgotten
GivenStories: localtests/mbmd/steps/TTP-24270.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
