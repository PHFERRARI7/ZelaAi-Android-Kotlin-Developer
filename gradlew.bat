@echo off
set APP_HOME=%~dp0
set JAR=%APP_HOME%gradle\wrapper\gradle-wrapper.jar
if not exist "%JAR%" (
  echo gradle-wrapper.jar nao encontrado.
  exit /b 1
)
java -classpath "%JAR%" org.gradle.wrapper.GradleWrapperMain %*
