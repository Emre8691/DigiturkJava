!-- ----------------
!-- TTP-15246 - Homeconnect Webservice Test Auth2.0 get AccessToken Tests - (Prod Pilot RNA)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://icore-ws.bsh-partner.com
Given is webservice authentication

!-- ----------------
!-- TTP-15246 - Homeconnect Webservice Test Auth2.0 get AccessToken Tests - (Prod Pilot RNA)
Scenario: TTP-15246 - Homeconnect Webservice Test Auth2.0 get AccessToken Tests - (Prod Pilot RNA)
GivenStories: localtests/no_component/steps/TTP-15246.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
