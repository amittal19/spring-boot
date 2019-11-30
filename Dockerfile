FROM openjdk:8
ADD target/spring-boot-slf4j.jar spring-boot-slf4j.jar
CMD java -jar spring-boot-slf4j.jar
