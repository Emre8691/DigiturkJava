!-- ----------------
!-- TTP-373 - Automatic: StaffSales check ServiceItems
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-373 - Automatic: StaffSales check ServiceItems
Scenario: TTP-373 - Automatic: StaffSales check ServiceItems
GivenStories: migration/TTP-391/steps/TTP-373.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
