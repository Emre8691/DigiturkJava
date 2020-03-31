!-- ----------------
!-- TTP-352 - Automatic: Staffsales Basic Functionalities - Fulltext search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-352 - Automatic: Staffsales Basic Functionalities - Fulltext search
Scenario: TTP-352 - Automatic: Staffsales Basic Functionalities - Fulltext search
GivenStories: migration/TTP-625/steps/TTP-352.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
