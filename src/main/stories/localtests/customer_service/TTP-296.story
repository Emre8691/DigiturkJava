!-- ----------------
!-- TTP-296 - Automatic: Customer Service: Competency Pages - Extended Warranty
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-296 - Automatic: Customer Service: Competency Pages - Extended Warranty
Scenario: TTP-296 - Automatic: Customer Service: Competency Pages - Extended Warranty
GivenStories: localtests/customer_service/steps/TTP-296.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
