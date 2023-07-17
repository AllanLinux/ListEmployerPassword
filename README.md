![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![MicrosoftSQLServer](https://img.shields.io/badge/Microsoft%20SQL%20Server-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white) ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white) ![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white) ![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white) [![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

# ListEmployerPassword

## Visão Geral
Esta aplicação é construída utilizando Spring Boot e inclui recursos como operações CRUD com o banco de dados usando Spring Data JPA, hash de senha com jBCrypt e visualizações HTML usando Thymeleaf. A aplicação está rodando com o Java 17.
Aplicação realiza o cadastro de um colaborador e lista os colaboradores cadastrados com seu respectivo gerente, retornando um score em forma de progressBar para o grau de complexidade informada na senha de cadastro.

## Tecnologias Usadas
- Java 17
- Spring Boot
- Spring Data JPA
- Microsoft SQL Server Driver
- Hibernate
- jBCrypt
- Thymeleaf

## Pré-requisitos
- Java Development Kit (JDK) 17
- Uma IDE (por exemplo, IntelliJ IDEA, Eclipse)
- Microsoft SQL Server

## Primeiros Passos
1. **Clone o repositório**: Primeiro, você precisará clonar o repositório usando o Git.

   ```
   git clone https://github.com/seu_usuario/seu_repo.git
   ```

2. **Abra o projeto na sua IDE**: Abra o projeto na sua IDE preferida que suporte Spring Boot e Java 17.

3. **Atualize o arquivo application.properties**: Abra o arquivo `src/main/resources/application.properties` e atualize a URL do JDBC, o nome de usuário e a senha para corresponder à configuração do seu banco de dados Microsoft SQL Server.

   ```
   spring.datasource.url=jdbc:sqlserver://localhost;databaseName=seu_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. **Execute a aplicação**: Você pode executar a aplicação executando o método principal na classe principal a partir de sua IDE.

Alternativamente, você pode construir o projeto e executá-lo usando a linha de comando:

```
./mvnw package
java -jar target/nome-da-sua-aplicação-0.0.1-SNAPSHOT.jar
```

A aplicação estará acessível em `http://localhost:8080`.

## Recursos
Esta aplicação suporta as seguintes operações:

- **Operações Create, Read, Update, Delete (CRUD)**: A aplicação pode realizar operações CRUD no banco de dados usando Spring Data JPA e Hibernate.

- **Hash de senha**: As senhas dos usuários são hashed usando jBCrypt, fornecendo uma maneira segura de armazenar as senhas dos usuários.

- **Visualizações HTML**: A aplicação usa Thymeleaf para criar visualizações HTML, fornecendo uma interface amigável ao usuário para interagir com a aplicação.

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE.md](https://github.com/seu_usuario/seu_repo/LICENSE.md) para detalhes.
