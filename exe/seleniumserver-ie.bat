@echo off
netstat /o /a | find /i "listening" | find ":4444" >nul
cls
if errorlevel 1 (
echo. start Selenium grid
start cmd /k "cd Server && java  -Dwebdriver.ie.driver="C:\DevCommonFiles\ie\IEDriverServer.exe" -jar "C:\DevCommonFiles\Selenium\selenium-server-standalone-3.141.59.jar"
) ELSE (
echo "bye"
)

