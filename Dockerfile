FROM maven:3.8.5-openjdk-17

WORKDIR /app
COPY . /app

CMD ["mvn", "clean", "test", "-Dtest=*ApiTest"]