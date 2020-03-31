!-- ----------------
!-- TTP-374 - Automatic: Login Functionality (Staff Sales)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'STAFF' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-374 - Automatic: Login Functionality (Staff Sales)
Scenario: TTP-374 - Automatic: Login Functionality (Staff Sales)
GivenStories: localtests/staff_sales/steps/TTP-374.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
