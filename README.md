<h2 align="center">SPOT Management System</h2>

<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
</div>

<p align="center">
 <a href="#description">Description</a> • 
 <a href="#features">Features</a> • 
 <a href="#installation">Installation</a> •
 <a href="#contribution">Contribution</a> 
</p>

<h2 id="description">📙 Description</h2>
The Radio SPOT Management System is a full-stack Java application developed to facilitate the management and registration of advertising SPOTS linked to radio stations. A SPOT is a short advertisement broadcast on a radio station, usually paid for by companies to promote their products or services.

<h2 id="features">✨ Features</h2>

- **SPOT Registration**: Including information about the announcer, the advertising company, and other relevant details.
- **View** and **Edit** Registered SPOTS.
- **Advanced Search**: To find specific SPOTS.

### Technologies Used

- **Java**: Primary programming language.
- **Spring Framework**: Used for the backend layer, including Spring Boot and Spring Data.
- **JSF (JavaServer Faces)**: Framework used for developing the frontend layer.
- **Primefaces**: Components used to create a rich and interactive user interface.

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- Maven for dependency management.

<h2 id="installation">🛠️ Installation</h2>

1. Clone the repository to your local environment:

```
git clone https://github.com/lucasrznd/sistema-gspot.git
```

2. Configure your database (I used MySQL, but use your preferred database):

```
spring.datasource.url=${MYSQL_URL}
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

3. Navigate to the project directory:

```
cd sistema-controle-spots
```

4. Compile the project using Maven:

```
mvn clean install
```

5. Run the generated JAR file in the target folder or deploy the JAR to your application server.

<h2 id="contribution">🤝 Contribution</h2>

Contributions are welcome! If you have suggestions, improvements, or find bugs, feel free to open an issue or submit a pull request.

<h2 id="author">👨🏻‍💻 Author</h2>

<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/lucasrznd"><img src="https://avatars.githubusercontent.com/u/101664450?v=4&v=" width="115px;" alt="Lucas Rezende"/><br /><sub><b>Lucas Rezende</b></sub></a><br/><a title="Código">💻</a></td>
  </tbody>
</table>
