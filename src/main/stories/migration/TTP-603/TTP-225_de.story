!-- ----------------
!-- TTP-225 - Automatic: Customer Service : Spare Part Search: Search E-Number
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-225 - Automatic: Customer Service : Spare Part Search: Search E-Number
Scenario: TTP-225 - Automatic: Customer Service : Spare Part Search: Search E-Number
GivenStories: migration/TTP-603/steps/TTP-225.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
