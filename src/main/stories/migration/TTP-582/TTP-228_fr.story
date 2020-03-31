!-- ----------------
!-- TTP-228 - Automatic: Spare parts search result steps
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'D2C' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-228 - Automatic: Spare parts search result steps
Scenario: TTP-228 - Automatic: Spare parts search result steps
GivenStories: migration/TTP-582/steps/TTP-228.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
