!-- ----------------
!-- TTP-23857 - Siemens - Hybris Staff - single item - LDA
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'STAFF' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23857 - Siemens - Hybris Staff - single item - LDA
Scenario: TTP-23857 - Siemens - Hybris Staff - single item - LDA
GivenStories: localtests/sap/steps/TTP-23857.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
