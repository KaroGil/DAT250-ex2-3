# Start from base image = gradle
FROM gradle:7.6-jdk17 AS builder
LABEL authors="karolinagil"

# Get inside the right path
WORKDIR /home/gradle

# Copy the app
COPY settings.gradle.kts gradlew build.gradle.kts ./
COPY src src
COPY gradle gradle

# Make the Gradle wrapper executable
RUN chmod +x ./gradlew

# Build the application and package it with bootJar
RUN ./gradlew clean build bootJar --no-daemon --stacktrace

# rename and move the resulting JAR file
RUN mv build/libs/DAT250-ex2-3.jar app.jar

CMD ["java", "-jar", "app.jar"]