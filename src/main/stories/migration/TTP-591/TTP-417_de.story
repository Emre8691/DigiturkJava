!-- ----------------
!-- TTP-417 - Automatic: CEW: Appliance serial number validations
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-417 - Automatic: CEW: Appliance serial number validations
Scenario: TTP-417 - Automatic: CEW: Appliance serial number validations
GivenStories: migration/TTP-591/steps/TTP-417.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
