!-- ----------------
!-- TTP-311 - Automatic : Payment: Voucher
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-311 - Automatic : Payment: Voucher
Scenario: TTP-311 - Automatic : Payment: Voucher
GivenStories: migration/TTP-613/steps/TTP-311.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
