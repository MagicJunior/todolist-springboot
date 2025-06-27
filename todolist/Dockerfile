# Etapa 1 - Build
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2 - Execucao
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o jar gerado pelo Maven
COPY --from=build /app/target/*.jar app.jar

# Copia o wait-for-it.sh para dentro do container
COPY wait-for-it.sh /app/wait-for-it.sh

# Permissão de execução para o script
RUN chmod +x /app/wait-for-it.sh

EXPOSE 8080

# Usa o wait-for-it.sh antes de subir o jar
ENTRYPOINT ["./wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "app.jar"]
