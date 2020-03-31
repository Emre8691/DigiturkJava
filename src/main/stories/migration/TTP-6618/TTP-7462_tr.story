!-- ----------------
!-- TTP-7462 - [Prod] - Add one item from all category - Delete 10 item from Basket Login - GARANTI Payment - BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-7462 - [Prod] - Add one item from all category - Delete 10 item from Basket Login - GARANTI Payment - BOSCH-TR
Scenario: TTP-7462 - [Prod] - Add one item from all category - Delete 10 item from Basket Login - GARANTI Payment - BOSCH-TR
GivenStories: migration/TTP-6618/steps/TTP-7462.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
