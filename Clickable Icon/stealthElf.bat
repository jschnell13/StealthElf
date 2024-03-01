@ECHO OFF
set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;C:\Users\Jordan\Desktop\Spring 2024\CYBR 404\StealthElf\test\out\artifacts\test_jar\test.jar

start cmd /k ""%JAVA_HOME%\bin\java" -Xms128m -Xmx384m -Xnoclassgc Main"