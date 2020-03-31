!-- ----------------
!-- TTP-100296 - Bosch - (MBMD)- Staff - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch singapore
Given is 'D2C' website for brand 'Bosch' and country 'singapore' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100296 - Bosch - (MBMD) -  D2C - Fulltext Search
Scenario: TTP-100296 - Bosch - (MBMD) - Staff - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-100296.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
