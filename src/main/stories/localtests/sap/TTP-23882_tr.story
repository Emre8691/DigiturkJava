!-- ----------------
!-- TTP-23882 -  Profilo - single item - LDA - only B product (stock in CKY, no stock in KAR)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23882 -  Profilo - single item - LDA - only B product (stock in CKY, no stock in KAR)
Scenario: TTP-23882 -  Profilo - single item - LDA - only B product (stock in CKY, no stock in KAR)
GivenStories: localtests/sap/steps/TTP-23882.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
