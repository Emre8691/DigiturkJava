!-- ----------------
!-- TTP-23858 - Profilo - Hybris Staff - single item - CP
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23858 - Profilo - Hybris Staff - single item - CP
Scenario: TTP-23858 - Profilo - Hybris Staff - single item - CP
GivenStories: localtests/sap/steps/TTP-23858.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
