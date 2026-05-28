#!/bin/bash
# Check if the Java app is running and kill it safely before deploying the new version
PID=$(pgrep -f 'todo-app-1.0.0.jar')
if [ -z "$PID" ]; then
    echo "Application is not running."
else
    echo "Stopping application..."
    kill -9 $PID
fi
