!-- ----------------
!-- TTP-14867 - (DS) Product Detailed Page ND - Product Images  PDP1 -V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'D2C' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14867 - (DS) Product Detailed Page ND - Product Images  PDP1 -V1
Scenario: TTP-14867 - (DS) Product Detailed Page ND - Product Images  PDP1 -V1
GivenStories: localtests/m.onsite_search/steps/TTP-14867.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
