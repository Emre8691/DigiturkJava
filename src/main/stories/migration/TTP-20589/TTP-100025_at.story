!-- ----------------
!-- TTP-100025 - Siemens - (MBMD) - RES1- new User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS austria
Given is 'D2C' website for brand 'SIEMENS' and country 'austria'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-24255 - Siemens - (MBMD) - RES1- new User Registration
Scenario: TTP-24255 - Siemens - (MBMD) - RES1- new User Registration
GivenStories: migration/TTP-20589/steps/TTP-100025.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
