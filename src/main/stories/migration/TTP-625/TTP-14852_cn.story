!-- ----------------
!-- TTP-14852 - (DS) Basic Functionalities ND - Product Filter BAS5 -V2
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS china
Given is 'D2C' website for brand 'SIEMENS' and country 'china'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14852 - (DS) Basic Functionalities ND - Product Filter BAS5 -V2
Scenario: TTP-14852 - (DS) Basic Functionalities ND - Product Filter BAS5 -V2
GivenStories: migration/TTP-625/steps/TTP-14852.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
