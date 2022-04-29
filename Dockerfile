FROM openjdk:11
COPY . /build/libs/
WORKDIR /build/libs/
EXPOSE 8080
ENV TZ=America/Bogota
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD ["java","-jar","target/spa-0.0.1-SNAPSHOT.jar"]