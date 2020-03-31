!-- ----------------
!-- TTP-100266 - Bosch - (MBMD)- Staff - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch finland
Given is 'STAFF' website for brand 'Bosch' and country 'finland' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100266 - Bosch - (MBMD) - Fulltext Search
Scenario: TTP-100266 - Bosch - (MBMD) - Staff - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-100266.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
