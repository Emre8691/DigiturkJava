!-- ----------------
!-- TTP-1955 - Registration:Staff Sales: Invite Friends&Family
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'STAFF' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1955 - Registration:Staff Sales: Invite Friends&Family
Scenario: TTP-1955 - Registration:Staff Sales: Invite Friends&Family
GivenStories: migration/TTP-584/steps/TTP-1955.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
