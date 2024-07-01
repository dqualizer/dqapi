 FROM gradle:8 as builder
ARG GITHUB_USER
ARG GITHUB_TOKEN

WORKDIR /app
COPY . .

RUN gradle -PgprPassword=$GITHUB_TOKEN -PgprUsername=$GITHUB_USER assemble --no-daemon


#### ----------- Runner Definiton ----------- ###
FROM eclipse-temurin:21-jre-alpine as rt

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/dqapi.jar

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=5 CMD "wget -T5 -qO- http://localhost:8099/actuator/health | grep UP || exit 1"

# Run the jar file
CMD [ "java", "-jar", "dqapi.jar" ]
