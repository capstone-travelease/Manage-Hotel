FROM openjdk:21

VOLUME /tmp

COPY target/*.jar manage-hotel-0.0.1-SNAPSHOT.jar

EXPOSE 1503
ENTRYPOINT ["java","-jar","/manage-hotel-0.0.1-SNAPSHOT.jar"]