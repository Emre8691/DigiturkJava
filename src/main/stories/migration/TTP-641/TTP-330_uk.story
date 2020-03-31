!-- ----------------
!-- TTP-330 - Automatic: Product Pages: Category Page with Filters (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'D2C' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-330 - Automatic: Product Pages: Category Page with Filters (Bosch)
Scenario: TTP-330 - Automatic: Product Pages: Category Page with Filters (Bosch)
GivenStories: migration/TTP-641/steps/TTP-330.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
