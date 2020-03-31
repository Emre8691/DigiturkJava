!-- ----------------
!-- TTP-354 - Automatic: Staffsales Spare Parts Search - E-number
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'STAFF' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-354 - Automatic: Staffsales Spare Parts Search - E-number
Scenario: TTP-354 - Automatic: Staffsales Spare Parts Search - E-number
GivenStories: localtests/staff_sales/steps/TTP-354.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
