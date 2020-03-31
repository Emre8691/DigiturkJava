!-- ----------------
!-- TTP-2332 - Homeconnect Webservice Test - Register a New user - Delete the user
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://future-int.ws.d2cfarm.com
Given is webservice authentication

!-- ----------------
!-- TTP-2332 - Homeconnect Webservice Test - Register a New user - Delete the user
Scenario: TTP-2332 - Homeconnect Webservice Test - Register a New user - Delete the user
GivenStories: migration/TTP-2529/steps/TTP-2332.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
