!-- ----------------
!-- TTP-14163 - CEW For BOSCH GB - purchase date is older than 28 day
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'D2C' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14163 - CEW For BOSCH GB - purchase date is older than 28 day
Scenario: TTP-14163 - CEW For BOSCH GB - purchase date is older than 28 day
GivenStories: localtests/ecommerce/steps/TTP-14163.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
