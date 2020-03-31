!-- ----------------
!-- TTP-310 - Not automatable; Automatic: Customer Service : Spare Part Search: OCR scanning/Spare Part List
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-310 - Not automatable; Automatic: Customer Service : Spare Part Search: OCR scanning/Spare Part List
Scenario: TTP-310 - Not automatable; Automatic: Customer Service : Spare Part Search: OCR scanning/Spare Part List
GivenStories: localtests/customer_service/steps/TTP-310.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
