!-- ----------------
!-- TTP-23878 - Siemens - single item - LDA - only B product (stock in CKY, no stock in KAR)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'STAFF' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23878 - Siemens - single item - LDA - only B product (stock in CKY, no stock in KAR)
Scenario: TTP-23878 - Siemens - single item - LDA - only B product (stock in CKY, no stock in KAR)
GivenStories: migration/TTP-24026/steps/TTP-23878.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
