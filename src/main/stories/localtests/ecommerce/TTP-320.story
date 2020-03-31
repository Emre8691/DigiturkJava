!-- ----------------
!-- TTP-320 - Automatic: Payment: Invoice
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-320 - Automatic: Payment: Invoice
Scenario: TTP-320 - Automatic: Payment: Invoice
GivenStories: localtests/ecommerce/steps/TTP-320.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
