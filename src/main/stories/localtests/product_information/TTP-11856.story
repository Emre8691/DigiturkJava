!-- ----------------
!-- TTP-11856 - PI - Marketing List Page - BazaarVoice
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11856 - PI - Marketing List Page - BazaarVoice
Scenario: TTP-11856 - PI - Marketing List Page - BazaarVoice
GivenStories: localtests/product_information/steps/TTP-11856.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
