!-- ----------------
!-- TTP-244 - Automatic: Payment: Visa/Master Invalid
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-244 - Automatic: Payment: Visa/Master Invalid
Scenario: TTP-244 - Automatic: Payment: Visa/Master Invalid
GivenStories: localtests/ecommerce/steps/TTP-244.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
