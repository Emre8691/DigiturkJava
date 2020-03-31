!-- ----------------
!-- TTP-100226 - Bosch - (MBMD)- Staff - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch Turkey
Given is 'STAFF' website for brand 'Bosch' and country 'turkey' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TEST-100226 - (MBMD) - BAS3 - Fulltext Search
Scenario: TEST-100226 - (MBMD) - Staff - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-100226.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
