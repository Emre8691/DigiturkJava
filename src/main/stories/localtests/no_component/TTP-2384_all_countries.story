!-- ----------------
!-- TTP-2384 - Homeconnect Webservice Test - Get Recipe and Specific Recipe
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://future-int.ws.d2cfarm.com
Given is webservice authentication

!-- ----------------
!-- TTP-2384 - Homeconnect Webservice Test - Get Recipe and Specific Recipe
Scenario: TTP-2384 - Homeconnect Webservice Test - Get Recipe and Specific Recipe
GivenStories: localtests/no_component/steps/TTP-2384.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
