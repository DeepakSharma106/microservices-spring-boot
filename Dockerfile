FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} departmentservice.jar

ENTRYPOINT ["java", "-jar", "/departmentservice.jar"]

EXPOSE 8081