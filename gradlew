#!/bin/sh
APP_HOME=$(cd "$(dirname "$0")" && pwd -P)
JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
if [ ! -f "$JAR" ]; then
  echo "gradle-wrapper.jar não encontrado." >&2
  exit 1
fi
exec java -classpath "$JAR" org.gradle.wrapper.GradleWrapperMain "$@"
