# Start from base image = gradle
FROM gradle:8-jdk21
LABEL authors="karolinagil"

# Get inside the right path
WORKDIR /dat250-ex2-3

# Copy the app
COPY . .

# Make the Gradle wrapper executable
RUN chmod +x ./gradlew

# Build the application and package it with bootJar
RUN ./gradlew clean build bootJar --stacktrace --info

# rename and move the resulting JAR file
RUN mv build/libs/A1-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]