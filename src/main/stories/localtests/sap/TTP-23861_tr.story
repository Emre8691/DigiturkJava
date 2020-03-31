!-- ----------------
!-- TTP-23861 - Siemens - Hybris - two items - CP&LDA
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'STAFF' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23861 - Siemens - Hybris - two items - CP&LDA
Scenario: TTP-23861 - Siemens - Hybris - two items - CP&LDA
GivenStories: localtests/sap/steps/TTP-23861.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
