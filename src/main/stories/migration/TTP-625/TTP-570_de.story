!-- ----------------
!-- TTP-570 - Automatic:Basic Functionalities:Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-570 - Automatic:Basic Functionalities:Fulltext Search
Scenario: TTP-570 - Automatic:Basic Functionalities:Fulltext Search
GivenStories: migration/TTP-625/steps/TTP-570.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
