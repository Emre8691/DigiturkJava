!-- ----------------
!-- TTP-100276 - Bosch - (MBMD)- Staff - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch denmark
Given is 'STAFF' website for brand 'Bosch' and country 'denmark' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100276 - Bosch - (MBMD) - Fulltext Search
Scenario: TTP-100276 - Bosch - (MBMD) - Staff - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-100276.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
