!-- ----------------
!-- TTP-23881 - Profilo - single item - CP - only B product
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23881 - Profilo - single item - CP - only B product
Scenario: TTP-23881 - Profilo - single item - CP - only B product
GivenStories: localtests/sap/steps/TTP-23881.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
