!-- ----------------
!-- TTP-17875 - (MBMD) - BAS3 - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch italy
Given is 'D2C' website for brand 'Bosch' and country 'italy'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17875 - (MBMD) - BAS3 - Fulltext Search
Scenario: TTP-17875 - (MBMD) - BAS3 - Fulltext Search
GivenStories: localtests/mbmd/steps/TTP-17875.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
