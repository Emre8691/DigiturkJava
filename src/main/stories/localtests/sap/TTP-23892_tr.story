!-- ----------------
!-- TTP-23892 -  Profilo - many items - A&B products -scenario1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23892 -  Profilo - many items - A&B products -scenario1
Scenario: TTP-23892 -  Profilo - many items - A&B products -scenario1
GivenStories: localtests/sap/steps/TTP-23892.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
