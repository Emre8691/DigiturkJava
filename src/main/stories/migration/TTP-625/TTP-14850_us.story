!-- ----------------
!-- TTP-14850 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS usa
Given is 'D2C' website for brand 'SIEMENS' and country 'usa'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14850 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V1
Scenario: TTP-14850 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V1
GivenStories: migration/TTP-625/steps/TTP-14850.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
