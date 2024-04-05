# Sistema de Controle de SPOTS de Rádio

O Sistema de Controle de SPOTS de Rádio é uma aplicação Java Fullstack desenvolvida para facilitar o gerenciamento e cadastro de SPOTS publicitários vinculados a rádios. Um SPOT é uma propaganda curta veiculada em uma estação de rádio, geralmente pagos pelas empresas para divulgar seus produtos ou serviços.

## Funcionalidades Principais

- Cadastro de SPOTS, incluindo informações sobre o locutor, a empresa anunciante e outros detalhes relevantes.
- Visualização e edição de SPOTS cadastrados.
- Pesquisa avançada para encontrar SPOTS específicos.

## Tecnologias Utilizadas

- Java: Linguagem de programação principal.
- Spring Framework: Utilizado para a camada de backend, incluindo Spring Boot e Spring Data.
- JSF (JavaServer Faces): Framework utilizado para o desenvolvimento da camada de frontend.
- Primefaces: Componentes utilizados para a criação de uma interface de usuário rica e interativa.

## Como Executar o Projeto

### Requisitos Prévios

- Java Development Kit (JDK) 17 ou superior.
- Maven para gerenciamento de dependências.

### Passos para Execução

1. Clone o repositório para o seu ambiente local:

```
git clone https://github.com/lucasrznd/sistema-gspot.git
```

2. Configure a sua base de dados (eu utilizei mySQL, mas utilize o de sua preferência):

```
spring.datasource.url=${MYSQL_URL}
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

3. Navegue até o diretório do projeto:

```
cd sistema-controle-spots
```

4. Compile o projeto utilizando o Maven:

```
mvn clean install
```

4. Execute o arquivo JAR gerado na pasta `target` ou implante o JAR em seu servidor de aplicação.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue se encontrar algum problema ou sugerir melhorias para o projeto.
