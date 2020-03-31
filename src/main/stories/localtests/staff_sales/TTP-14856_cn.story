!-- ----------------
!-- TTP-14856 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V4
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS china
Given is 'STAFF' website for brand 'SIEMENS' and country 'china'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14856 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V4
Scenario: TTP-14856 - (DS) Basic Functionalities ND - Fulltext Search  - BAS3 - V4
GivenStories: localtests/staff_sales/steps/TTP-14856.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
