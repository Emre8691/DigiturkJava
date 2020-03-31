!-- ----------------
!-- TTP-375 - No HMC automation; Automatic:  Staff Sales:User Registration (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'STAFF' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-375 - No HMC automation; Automatic:  Staff Sales:User Registration (Bosch)
Scenario: TTP-375 - No HMC automation; Automatic:  Staff Sales:User Registration (Bosch)
GivenStories: migration/TTP-584/steps/TTP-375.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
