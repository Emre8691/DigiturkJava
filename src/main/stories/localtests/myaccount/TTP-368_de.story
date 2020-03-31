!-- ----------------
!-- TTP-368 - Automatic: User Registration: Social Sign On Account Merge
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-368 - Automatic: User Registration: Social Sign On Account Merge
Scenario: TTP-368 - Automatic: User Registration: Social Sign On Account Merge
GivenStories: localtests/myaccount/steps/TTP-368.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
