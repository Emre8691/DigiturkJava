!-- ----------------
!-- TTP-698 - Production: Siemens Marketing Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS all countries
Given is 'D2C' website for brand 'SIEMENS' and country 'all countries'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-698 - Production: Siemens Marketing Search
Scenario: TTP-698 - Production: Siemens Marketing Search
GivenStories: localtests/m.onsite_search/steps/TTP-698.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
