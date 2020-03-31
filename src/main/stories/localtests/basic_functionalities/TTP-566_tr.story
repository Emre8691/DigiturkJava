!-- ----------------
!-- TTP-566 - Automatic:Basic Functionalities:Carousel
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'D2C' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-566 - Automatic:Basic Functionalities:Carousel
Scenario: TTP-566 - Automatic:Basic Functionalities:Carousel
GivenStories: localtests/basic_functionalities/steps/TTP-566.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
