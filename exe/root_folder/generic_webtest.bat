@REM -----------------------------------------------------------------------------------------------------
@REM
@REM  webtests - starting bsh webtests
@REM   
@REM  required environment:
@REM   
@REM  set JAVA_HOME to installed jdk directory
@REM  set MAVEN_HOME to installed maven directory
@REM   
@REM
@REM  - To do not start the selenium server always at first use argument "noserver"
@REM    (if already running the second instance is stopped automatically)    
@REM 
@REM  - To do start the selenium server from local repository press "Enter"
@REM
@REM  - To do start the selenium server on jenkins use argument "jenkins"
@REM
@REM  Additional note:
@REM
@REM  You can copy your individual configuration to webtests/src/main/resources/local.properties
@REM  (a template of this file is located in webtests/src/main/resources/bsh/webtests/config)
@REM
@REM -----------------------------------------------------------------------------------------------------

@echo off

@REM ==== Set WebTest Setting for Test !!! =====

echo.
echo --------------------------------------------------------------------------------------
echo ### Select the system by given short expression where you want to test by webtest. ###
echo --------------------------------------------------------------------------------------
echo.
echo Systems: 	
echo # -------------------------------------------- #
echo #  localhost # - #  predev01  # - #   sinint   #
echo #  futureint # - #  predev02  # - #            #
echo #  futuredev # - #  predev03  # - #            #
echo #  maintint  # - #  predev04  # - #            #
echo #  maintdev  # - #  predev05  # - #            #
echo #            # - #  predev06  # - #            #
echo #            # - #  predev07  # - #            #
echo #            # - #  predev08  # - #            #
echo #            # - #  predev09  # - #            #
echo #            # - #  predev10  # - #            #
echo #            # - #  predev11  # - #            #
echo #            # - #  predev12  # - #            #
echo #            # - #  predev13  # - #            #
echo #            # - #  predev14  # - #            #
echo # -------------------------------------------- #
echo.

SET /p SYSTEM=

echo --------------------------------------------------------------------------------------------------------
SET SERVER=

echo.
echo ------------------------------
echo ### Select Selenium Server ###
echo ------------------------------
echo.
echo Select Selenium Server:
echo # ---------- #
echo #  jenkins   # Start webtest with an jenkins selenium instance.
echo #  noserver  # Start webtest without selenium standalone server. The server has to be startet by user befor continue!
echo # ---------- #
echo.
echo --------------------------------------------------------------------------------------------------------------
echo !!! Otherwise continue with "automatically started Selenium Standalone Server" by submit without parameter !!!
echo --------------------------------------------------------------------------------------------------------------
echo.

SET /p SERVER=
echo --------------------------------------------------------------------------------------------------------

: REPEAT

echo.
echo ----------------------------------------
echo ### Select Smoketests configuration. ###
echo ----------------------------------------
echo.
echo Webtest Type:
echo # ------- #
echo #   a01   # Parameter for smoke testing Bosch 2013. (Not in use for the moment)
echo #   a02   # Parameter for smoke testing Siemens 2013.
echo #  smoke  # Parameter for running Smoke-Test.
echo #   all   # Parameter for running complete webtest.
echo #  check  # Parameter for running Checkout-Test.
echo #  login  # Parameter for running Login-Test.
echo #   cms   # Parameter for running Gaggenau-Test.
echo # rollout # Parameter for running Rollout Tests. (Currently Siemens)
echo #   old   # Parameter for running Old Tests which are activated on Jenkins. (Currently Siemens)
echo # ------- #

SET /p STORY=

@REM Which testcase you need?
IF NOT "%STORY%" == "old" (
	IF NOT "%STORY%" == "rollout" (
		IF NOT "%STORY%" == "cms" (
			IF NOT "%STORY%" == "login" (
				IF NOT "%STORY%" == "check" (
					IF NOT "%STORY%" == "a01" (
						IF NOT "%STORY%" == "a02" (
							IF NOT "%STORY%" == "all" (
								IF "%STORY%" == "smoke" (
									@REM smoke = following test cases: **/basket_siemens_de_2013.story,**/checkout_buy_as_guest_bosch_de.story,**/checkout_user_login_siemens_at_2013.story,**/checkout_user_login_siemens_ch_de_2013.story,**/checkout_buy_as_guest_siemens_ch_de_2013.story,**/login_bosch_de.story,**/change_password_siemens_de.story,**/gaggenau_contact_de.story
									SET STORYPATH=jbehave.story.path.pattern="stable/smoke/**/*.story"
									) ELSE (
									IF NOT "%STORY%" == "" (
										SET STORYPATH=jbehave.story.path.pattern="**/*%STORY%*.story"
									) ELSE (
									GOTO REPEAT
									)
								)
							) ELSE (
								SET STORYPATH=jbehave.story.path.pattern="**/*.story"
							)
						) ELSE (
							SET STORYPATH=jbehave.story.path.pattern="**/*siemens*2013.story"
						)
					) ELSE (
						SET STORYPATH=jbehave.story.path.pattern="**/*bosch*2013.story"
					)
				) ELSE (
					SET STORYPATH=jbehave.story.path.pattern="**/checkout*.story"
				)
			) ELSE (
				SET STORYPATH=jbehave.story.path.pattern="**/login*.story"
			)
		) ELSE (
			SET STORYPATH=jbehave.story.path.pattern="stable/**/gaggenau*.story"
		)
	) ELSE (
			SET STORYPATH=jbehave.story.path.pattern="rollout/**/*.story"
	)
) ELSE (
	SET STORYPATH=jbehave.story.path.pattern="stable/**/*.story"
)

	
SET BROWSERPATH=selenium.browser.path=%cd%/FirefoxPortable/App/Firefox/firefox.exe

echo --------------------------------------------------------------------------------------------------------


SET TESTEDSYSTEM=bsh.testedSystem=%SYSTEM%
SET METAFILTER=jbehave.meta.filter="-missingproducts, -missingpayment.exclude *bosch_us *bosch_be*, -nostageproduct.exclude checkout_siemens_uk, -nodeliveryaddressdeviant.exclude *bosch_be*, -exclude_notready, -template_switch.exclude *siemens_de_2013 *siemens_ch_de_2013*, -template_switch.exclude *siemens_uk_2013*"
          
echo.
echo ---------------------------------------
echo ### WebTest Settings for Smoke Test ###
echo ---------------------------------------
echo.
echo.
echo TESTEDSYSTEM: %TESTEDSYSTEM%
echo METAFILTER  : %METAFILTER%
echo STORYPATH   : %STORYPATH%
echo BROWSERPATH : %BROWSERPATH%
echo SERVER 	 : %SERVER%
echo.
echo.
echo ---------------------------------------


@REM ==== WebTest Setting for SmokeTest via Jenkins Selenium Server ====
SET USE_JENKINS_SELENIUMSERVER=false

IF "%SERVER%" == "jenkins" (
	SET USE_JENKINS_SELENIUMSERVER=true
	CALL selenium_properties.bat
)

@REM ==== START VALIDATION ====
IF "%JAVA_HOME%" == "" (
	echo No JDK found - JAVA_HOME is not set
	exit
)
IF "%MAVEN_HOME%" == "" (
	echo No Maven found - MAVEN_HOME is not set
	exit
)

@REM ==== DO SCRIPT ====
CALL mvn clean compile

@REM ==== Starts SELENIUM STANDALONE SERVER if starting file without goal ====
IF not "%SERVER%" == "noserver"  (
	IF not "%SERVER%" == "jenkins" (
		START CMD /C C:\BSHWebTests\Maven\bin\mvn antrun:run -Duse-firefox-portable=true
	)
)

@REM ==== If USE_JENKINS_SELENIUMSERVER is false, webtest will starting on local system with selenium standalone server, else webtest will started by Jenkins ====
IF "%USE_JENKINS_SELENIUMSERVER%" == "false" (
	echo.
	echo ########## STARTING selenium server ##########
	echo.
	
	timeout /T 15 /NOBREAK > nul
	CALL C:\BSHWebTests\Maven\bin\mvn integration-test -D%TESTEDSYSTEM% -D%METAFILTER% -D%STORYPATH% -D%BROWSERPATH%
	CALL C:\BSHWebTests\Maven\bin\mvn selenium:stop-server
	) ELSE (
	echo.
	echo ########## Using selenium server on %JENKINS_SELENIUMSERVER% ##########
	echo.
	
	CALL C:\BSHWebTests\Maven\bin\mvn integration-test -D%TESTEDSYSTEM% -D%METAFILTER% -D%STORYPATH% -D%JENKINS_SELENIUMSERVER% -D%JENKINS_SELENIUMBROWSER% -D%JENKINS_SELENIUMBROWSER_VERSION%
)

@REM ==== Opens the report file of JBehave as browser tab ====
echo.
echo ########## Open jbehave reports.html to show results ##########
echo.

%cd%\target\jbehave\view\reports.html

echo SCRIPT DONE
%comSpec%
