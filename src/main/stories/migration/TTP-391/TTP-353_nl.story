!-- ----------------
!-- TTP-353 - Automatic: Staffsales Product Pages - Product images
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-353 - Automatic: Staffsales Product Pages - Product images
Scenario: TTP-353 - Automatic: Staffsales Product Pages - Product images
GivenStories: migration/TTP-391/steps/TTP-353.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
