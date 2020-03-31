!-- ----------------
!-- TTP-11841 - PI - Marketing Product Detail Page - Product Gallery
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11841 - PI - Marketing Product Detail Page - Product Gallery
Scenario: TTP-11841 - PI - Marketing Product Detail Page - Product Gallery
GivenStories: localtests/pi.product_detail_page/steps/TTP-11841.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
