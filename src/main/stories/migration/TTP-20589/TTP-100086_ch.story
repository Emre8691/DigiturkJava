!-- ----------------
!-- TTP-100076 - (MBMD) - BAS3 - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens denmark
Given is 'D2C' website for brand 'Siemens' and country 'switzerland' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TEST-100086 - (MBMD) - BAS3 - Fulltext Search
Scenario: TEST-100086 - (MBMD) - BAS3 - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-100086.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
