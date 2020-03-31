!-- ----------------
!-- TTP-355 - Automatic: Staffsales MyAccount - Change "MyProfile" personal data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'STAFF' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-355 - Automatic: Staffsales MyAccount - Change "MyProfile" personal data
Scenario: TTP-355 - Automatic: Staffsales MyAccount - Change "MyProfile" personal data
GivenStories: localtests/staff_sales/steps/TTP-355.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
