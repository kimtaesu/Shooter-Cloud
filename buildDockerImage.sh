#!/usr/bin/env bash
# All docker service stop & remove

docker-compose down

./gradlew clean build

docker-compose up -d --build