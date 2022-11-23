# Build stage
FROM maven:3-openjdk-17 AS build
COPY . /dockerTemp
RUN mvn -f /dockerTemp/pom.xml clean install

# Run stage
# FROM openjdk:17-oracle
# WORKDIR /
# COPY --from=build /dockerTemp/target/web-project*.jar web-project.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","web-project.jar"]


# Memory optimized image
FROM ibm-semeru-runtimes:open-17-jre-focal
WORKDIR /
COPY --from=build /dockerTemp/target/web-project*.jar web-project.jar
EXPOSE 8080
ENTRYPOINT ["java","-XX:MaxRAM=70m", "-jar","web-project.jar"]