!-- ----------------
!-- TTP-42 - Duplicate:Automatic - My Account Login Staff Sales
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  
Given is 'STAFF' website for brand '' and country ''
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-42 - Duplicate:Automatic - My Account Login Staff Sales
Scenario: TTP-42 - Duplicate:Automatic - My Account Login Staff Sales
GivenStories: localtests/staff_sales/steps/TTP-42.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
