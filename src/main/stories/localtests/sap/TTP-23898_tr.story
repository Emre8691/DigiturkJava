!-- ----------------
!-- TTP-23898 - Siemens - eInvoice
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'D2C' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23898 - Siemens - eInvoice
Scenario: TTP-23898 - Siemens - eInvoice
GivenStories: localtests/sap/steps/TTP-23898.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
