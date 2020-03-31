!-- ----------------
!-- TTP-11850 - PI - Marketing List Page - Campaign Icons
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11850 - PI - Marketing List Page - Campaign Icons
Scenario: TTP-11850 - PI - Marketing List Page - Campaign Icons
GivenStories: localtests/pi.product_list_page/steps/TTP-11850.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
