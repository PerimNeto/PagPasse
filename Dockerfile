# Etapa 1: Build - compila o projeto com Maven usando Java 21
FROM maven:3.9-eclipse-temurin-21 as builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de definição do Maven primeiro (para cache mais eficiente)
COPY pom.xml .

# Baixa as dependências para acelerar builds futuros
RUN mvn dependency:go-offline -B

# Agora copia o restante do código
COPY src ./src

# Compila o projeto e gera o .jar
RUN mvn clean package -DskipTests

# --------------------------------------------------------------------

# Etapa 2: Runtime - roda a aplicação em uma imagem limpa e leve
FROM eclipse-temurin:21-jdk-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o .jar gerado na etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão (8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
