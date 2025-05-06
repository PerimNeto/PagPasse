# PagPasse

## 📱 Sobre o Projeto!!!

PagPasse é uma aplicação inovadora voltada para o transporte público em cidades inteligentes. Desenvolvida como uma solução moderna, eficiente e segura para gerenciar pagamentos de passagens e facilitar a mobilidade urbana, esta aplicação visa melhorar a experiência do usuário no uso do transporte público.

## 🚀 Tecnologias Utilizadas

- **Java 17** - Linguagem de programação principal
- **Spring Boot 3.3.4** - Framework para desenvolvimento de aplicações Java
- **Spring Security** - Para autenticação e autorização
- **Spring Data JPA** - Para persistência de dados
- **Flyway** - Para controle de versão e migração do banco de dados
- **JWT (JSON Web Token)** - Para implementação de autenticação stateless
- **MySQL & Oracle Database** - Bancos de dados suportados
- **Docker** - Para containerização da aplicação
- **Maven** - Gerenciador de dependências e build

## 📋 Requisitos de Sistema

- Java 17 ou superior
- Maven 3.6+
- MySQL ou Oracle Database
- Docker (opcional, para implantação em contêineres)

## 🔧 Configuração e Instalação

### Clone o Repositório

```bash
git clone https://github.com/OBuskas/pagpasse.git
cd pagpasse
```

### Configuração do Banco de Dados

Você precisa configurar as credenciais do banco de dados no arquivo `application.properties` ou `application.yml` na pasta `src/main/resources/`:

#### Para MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pagpasse_db
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

#### Para Oracle:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=system
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
```

## ▶️ Executando a Aplicação

### Usando Maven

Para sistemas Unix/Linux/macOS:
```bash
./mvnw clean install
./mvnw spring-boot:run
```

Para Windows:
```bash
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

### Usando Docker

#### Construir a imagem:
```bash
docker build -t pagpasse:latest .
```

#### Executar o contêiner:
```bash
docker run -p 8080:8080 pagpasse:latest
```

### Usando Docker Compose

```bash
docker-compose up
```

Este comando inicia a aplicação conforme configurado no arquivo `docker-compose.yml` presente no projeto.

## 🏗️ Arquitetura do Projeto

O PagPasse segue uma arquitetura de camadas típica de aplicações Spring Boot:

- **Controller**: Camada responsável por receber as requisições HTTP
- **Service**: Contém a lógica de negócio da aplicação
- **Repository**: Camada de acesso a dados
- **Model/Entity**: Representação das entidades do domínio
- **Config**: Configurações do Spring e da aplicação
- **Security**: Implementação de segurança e autenticação

## 🛠️ Principais Funcionalidades

- Autenticação e autorização de usuários
- Gerenciamento de pagamentos de passagens
- Integração com sistemas de transporte público
- Monitoramento de uso e histórico de transações

## 🔒 Segurança

A aplicação utiliza Spring Security com JWT para autenticação:

1. O usuário faz login e recebe um token JWT
2. O token é incluído no cabeçalho de autorizações subsequentes
3. O sistema valida o token e autoriza o acesso aos recursos

Para personalizar as configurações de segurança, ajuste os parâmetros no arquivo de configuração da aplicação.

## 📊 Banco de Dados

### Migrações com Flyway

O projeto utiliza Flyway para gerenciar as migrações de banco de dados de forma controlada:

- Os scripts de migração estão localizados em `src/main/resources/db/migration/`
- Seguem o padrão de nomenclatura `V{VERSÃO}__{DESCRIÇÃO}.sql`
- São executados automaticamente na ordem sequencial das versões

## 🚢 CI/CD com GitHub Actions

A aplicação já está configurada com GitHub Actions para integração contínua e entrega contínua. Os pipelines automatizam:

- Build do projeto
- Execução de testes
- Verificação de qualidade de código
- Implantação em ambientes específicos

Os workflows estão definidos na pasta `.github/workflows/` do repositório.

## 🧪 Testes e Verificação de Qualidade

### Estrutura de Testes

O projeto segue uma abordagem abrangente de testes que inclui:

- Testes Unitários
- Testes de Integração
- Testes de API
- Testes de Performance
- Testes de Segurança

### Arquivos de Teste

O projeto inclui uma estrutura completa de testes organizada em:

- `src/test/java/`: Contém todos os testes unitários e de integração
- `src/test/resources/`: Arquivos de configuração e dados de teste
- `test/docker/`: Arquivos Docker para ambiente de teste
- `test/scripts/`: Scripts de configuração e automação

### Executando os Testes

#### Testes Unitários e de Integração
```bash
./mvnw test
```

#### Testes de API
```bash
./mvnw verify -Papi-tests
```

#### Testes de Performance
```bash
./mvnw verify -Pperformance-tests
```

### Configuração do Ambiente de Teste

O projeto inclui arquivos de configuração específicos para o ambiente de teste:

- `src/test/resources/application-test.yml`: Configurações específicas para teste
- `test/docker/Dockerfile.test`: Imagem Docker personalizada para testes
- `test/docker/docker-compose.test.yml`: Configuração do ambiente de teste com Docker Compose

### Scripts de Teste

Os scripts de teste estão localizados em `test/scripts/` e incluem:

- `setup-test-env.sh`: Configura o ambiente de teste
- `run-performance-tests.sh`: Executa testes de performance
- `security-scan.sh`: Realiza varredura de segurança

### Documentação de Testes

Para mais detalhes sobre a estrutura e execução dos testes, consulte:

- [TESTING.md](test/TESTING.md): Guia completo sobre testes
- [PERFORMANCE.md](test/PERFORMANCE.md): Guia de testes de performance
- [SECURITY.md](test/SECURITY.md): Guia de testes de segurança

## 📝 Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE) - veja o arquivo LICENSE para detalhes.

## 👥 Contribuição

Para contribuir com o projeto:

1. Faça um Fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Implemente suas mudanças e adicione testes quando possível
4. Execute os testes: `./mvnw test`
5. Commit suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
6. Push para a branch (`git push origin feature/nova-funcionalidade`)
7. Abra um Pull Request

## 📚 Documentação da API

A documentação da API será disponibilizada através do Swagger UI após a inicialização da aplicação:

```
http://localhost:8080/swagger-ui.html
```

## 🔧 Ferramentas de Build

O projeto utiliza Maven como ferramenta de build, com configurações definidas no `pom.xml`. O Maven Wrapper (mvnw) está incluído para garantir compatibilidade entre diferentes ambientes de desenvolvimento.

## 📞 Suporte e Contato

Para questões, sugestões ou problemas, abra uma Issue no GitHub ou entre em contato através de:

- Email: [lucas.barbosa12397@gmail.com]
- Website: [https://bento.me/lucasbarbosa]

## 📈 Roadmap de Desenvolvimento

- Implementação de funcionalidades de pagamento via NFC
- Dashboard para acompanhamento de gastos
- Integração com sistemas de notificação em tempo real
- Suporte para múltiplas cidades e sistemas de transporte

---