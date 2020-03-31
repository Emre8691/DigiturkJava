!-- ----------------
!-- TTP-14854 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V2
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14854 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V2
Scenario: TTP-14854 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V2
GivenStories: localtests/m.onsite_search/steps/TTP-14854.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
