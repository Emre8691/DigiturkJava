!-- ----------------
!-- TTP-11847 - PI - Marketing List Page - Feature Icons
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11847 - PI - Marketing List Page - Feature Icons
Scenario: TTP-11847 - PI - Marketing List Page - Feature Icons
GivenStories: localtests/pi.product_list_page/steps/TTP-11847.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
