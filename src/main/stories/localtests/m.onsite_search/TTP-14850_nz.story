!-- ----------------
!-- TTP-14850 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS newzealand
Given is 'D2C' website for brand 'SIEMENS' and country 'newzealand'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14850 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V1
Scenario: TTP-14850 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V1
GivenStories: localtests/m.onsite_search/steps/TTP-14850.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
