!-- ----------------
!-- TTP-23875 -  Bosch - single item - LDA - only B product (stock in KAR, no stock in CKY)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'STAFF' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23875 -  Bosch - single item - LDA - only B product (stock in KAR, no stock in CKY)
Scenario: TTP-23875 -  Bosch - single item - LDA - only B product (stock in KAR, no stock in CKY)
GivenStories: localtests/sap/steps/TTP-23875.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
