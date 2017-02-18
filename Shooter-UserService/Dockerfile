FROM java:openjdk-8u91-jdk
COPY build/libs/Shooter-UserService.jar .
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar Shooter-UserService.jar"]
