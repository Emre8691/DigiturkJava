!-- ----------------
!-- TTP-23859 - Profilo - Hybris Staff - single item - LDA
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23859 - Profilo - Hybris Staff - single item - LDA
Scenario: TTP-23859 - Profilo - Hybris Staff - single item - LDA
GivenStories: localtests/sap/steps/TTP-23859.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
