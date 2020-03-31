!-- ----------------
!-- TTP-23956 - (MBMD) Energy Label Testing
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'D2C' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23956 - (MBMD) Energy Label Testing
Scenario: TTP-23956 - (MBMD) Energy Label Testing
GivenStories: localtests/pi.product_detail_page/steps/TTP-23956.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
