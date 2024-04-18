# Build a JAR File
FROM maven:3.8.4-openjdk-17-slim AS stage1
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create an Image
FROM amazoncorretto:17-alpine-jdk
EXPOSE 8090
COPY --from=stage1 /home/app/target/e-books-store-0.0.1-SNAPSHOT.jar e-books-store.jar
ENTRYPOINT ["sh", "-c", "java -jar /e-books-store.jar"]


