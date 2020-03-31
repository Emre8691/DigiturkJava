!-- ----------------
!-- TTP-23883 - Profilo - single item - LDA - only B product (stock in KAR, no stock in CKY)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Profilo turkey
Given is 'STAFF' website for brand 'Profilo' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23883 - Profilo - single item - LDA - only B product (stock in KAR, no stock in CKY)
Scenario: TTP-23883 - Profilo - single item - LDA - only B product (stock in KAR, no stock in CKY)
GivenStories: migration/TTP-24026/steps/TTP-23883.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
