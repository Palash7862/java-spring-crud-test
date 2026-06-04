# Java 21 base image
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy Maven wrapper files FIRST (best practice)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Fix permissions for Linux container
RUN chmod +x mvnw

# Download dependencies (cached layer → faster builds)
# RUN ./mvnw dependency:go-offline

# Now copy source code
COPY src ./src

EXPOSE 8080

# Run Spring Boot in dev mode (like Laravel Sail)
CMD ["./mvnw", "spring-boot:run"]