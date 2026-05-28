#!/bin/bash
# Start the new Java application in the background
cd /home/ubuntu/app
nohup java -jar todo-app-1.0.0.jar > /home/ubuntu/app/server.log 2>&1 &
