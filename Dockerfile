FROM gradle:8 AS builder
ARG GITHUB_USER
ARG GITHUB_TOKEN

WORKDIR /app
COPY . .

RUN gradle -PgprPassword=$GITHUB_TOKEN -PgprUsername=$GITHUB_USER assemble --no-daemon


#### ----------- Runner Definiton ----------- ###
FROM eclipse-temurin:21-jre-alpine AS rt

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/dqapi.jar

EXPOSE 8080

HEALTHCHECK --interval=10s --timeout=10s --retries=10 --start-period=10s CMD wget --spider -q http://localhost:8099/actuator/health || exit 1

# Run the jar file
CMD [ "java", "-jar", "dqapi.jar" ]
