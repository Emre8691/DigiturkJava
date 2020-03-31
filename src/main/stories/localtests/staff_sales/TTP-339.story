!-- ----------------
!-- TTP-339 - Automatic: Staffsales Basic Functionalities - Category Flyout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-339 - Automatic: Staffsales Basic Functionalities - Category Flyout
Scenario: TTP-339 - Automatic: Staffsales Basic Functionalities - Category Flyout
GivenStories: localtests/staff_sales/steps/TTP-339.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
