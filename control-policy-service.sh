#!/usr/bin/env bash

COMMAND=$1 

JAVA_HOME=/usr/bin/java
JVM_ARGS="-jar -server"
JVM_PROPS="-Dserver.log.location=logs"

JAR_FILE='policy-service-*.jar'


if [ "$COMMAND" == "stop" ]; then
  echo "PROCESS_TO_KILL : $PROCESS_TO_KILL"
  kill -9 "${PROCESS_TO_KILL}"
elif [ "$COMMAND" == "start" ]; then
     CMD="$JAVA_HOME $JVM_ARGS  $JAR_FILE"
     nohup "${CMD}" > /dev/null &
fi
exit 0