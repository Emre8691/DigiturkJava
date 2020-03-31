!-- ----------------
!-- TTP-14853 - (DS) Basic Functionalities ND - Product Filter BAS5 -V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS malaysia
Given is 'D2C' website for brand 'SIEMENS' and country 'malaysia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14853 - (DS) Basic Functionalities ND - Product Filter BAS5 -V1
Scenario: TTP-14853 - (DS) Basic Functionalities ND - Product Filter BAS5 -V1
GivenStories: migration/TTP-625/steps/TTP-14853.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
