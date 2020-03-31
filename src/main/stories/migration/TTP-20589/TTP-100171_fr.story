!-- ----------------
!-- TTP-100171 - Bosch - (MBMD)- Staff - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch France
Given is 'STAFF' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TEST-100171 - (MBMD) - BAS3 - Fulltext Search
Scenario: TEST-100171 - (MBMD) - BAS3 - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-100171.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
