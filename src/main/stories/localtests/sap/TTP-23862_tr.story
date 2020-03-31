!-- ----------------
!-- TTP-23862 - Profilo - Hybris - two items - CP&LDA
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23862 - Profilo - Hybris - two items - CP&LDA
Scenario: TTP-23862 - Profilo - Hybris - two items - CP&LDA
GivenStories: localtests/sap/steps/TTP-23862.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
