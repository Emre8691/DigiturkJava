!-- ----------------
!-- TTP-221 - Automatic: Payment: Payment Visa/Master Valid
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-221 - Automatic: Payment: Payment Visa/Master Valid
Scenario: TTP-221 - Automatic: Payment: Payment Visa/Master Valid
GivenStories: localtests/ecommerce/steps/TTP-221.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
