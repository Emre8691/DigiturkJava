echo. start Selenium grid
start cmd /k "cd Server && java  -Dwebdriver.ie.driver="c:\jenkins\selenium\ie\IEDriverServer.exe" -jar selenium-server-standalone-2.39.0.jar -port 4455"
