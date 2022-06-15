FROM maven:3.6.0-jdk-11-slim
RUN mkdir /project
WORKDIR /project
COPY . .
CMD ["mvn", "clean", "install"]