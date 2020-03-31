!-- ----------------
!-- TTP-23894 - Profilo - many items - A&B products -scenario3
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23894 - Profilo - many items - A&B products -scenario3
Scenario: TTP-23894 - Profilo - many items - A&B products -scenario3
GivenStories: localtests/sap/steps/TTP-23894.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
