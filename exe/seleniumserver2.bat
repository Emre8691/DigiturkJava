echo. start Selenium grid
start cmd /k "cd Selenium && java -Dwebdriver.server.session.timeout=3600 -jar selenium-server-standalone-2.39.0.jar -port 4444 -role hub"
SLEEP 20
echo.
echo.
echo.
echo.
echo.
start cmd /k "cd Selenium && java -Dwebdriver.server.session.timeout=3600 -Dwebdriver.firefox.bin="c:\DevCommonFiles\FirefoxPortable\App\Firefox\firefox.exe" -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4444/grid/register -port 4445"
echo.
echo.