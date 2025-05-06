# Etapa 1: Build (otimizada para cache)
FROM maven:3.9-eclipse-temurin-21 as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Cache eficiente de dependências
RUN mkdir -p target \
    && mvn dependency:go-offline -B \
    && mvn clean package -DskipTests

# --------------------------------------------

# Etapa 2: Runtime (com segurança reforçada)
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia o JAR mantendo o nome original (importante para o workflow)
COPY --from=builder /app/target/PagPasse-*.jar app.jar

# Configurações de segurança e performance
RUN apt-get update && apt-get install -y --no-install-recommends \
    fontconfig libfreetype6 \
    && rm -rf /var/lib/apt/lists/*

# Usuário não-root (boa prática de segurança)
RUN useradd -m appuser && chown -R appuser:appuser /app
USER appuser

EXPOSE 8080

# Parâmetros recomendados para apps Java em container
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Dfile.encoding=UTF-8", "-jar", "/app/app.jar"]