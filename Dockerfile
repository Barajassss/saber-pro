FROM eclipse-temurin:17-jdk

COPY . .

RUN ./mvnw -DskipTests package

RUN mv target/*.jar app.jar

EXPOSE 8088

CMD ["java", "-jar", "app.jar"]
