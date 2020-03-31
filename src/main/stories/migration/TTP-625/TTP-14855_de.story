!-- ----------------
!-- TTP-14855 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V3
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'STAFF' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14855 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V3
Scenario: TTP-14855 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V3
GivenStories: migration/TTP-625/steps/TTP-14855.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
