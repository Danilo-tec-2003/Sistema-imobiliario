# 🏡 Sistema Imobiliário

Projeto desenvolvido em Java com Spring Boot para gerenciar imóveis, clientes e transações imobiliárias.  
Este sistema permite o cadastro, consulta e gerenciamento de propriedades e clientes, facilitando a administração de uma imobiliária.

## 🚀 Tecnologias Utilizadas

- Java 23  
- Spring Boot 3.x  
- Spring Data JPA  
- Maven  
- MYSQL 
- Lombok

## ⚙️ Configuração do Banco de Dados

O projeto utiliza MySQL como banco de dados. Certifique-se de que o MySQL esteja instalado e em execução.

### 📌 Criar Banco de Dados

Acesse o MySQL:

mysql -u root -p
Execute o comando:

CREATE DATABASE real_estate_system;
USE real_estate_system;

⚙️ application.properties
O projeto está configurado com as seguintes propriedades:

properties
spring.application.name=real_estate_system

spring.datasource.url=jdbc:mysql://localhost:3307/real_estate_system
# (atente-se em qual porta o seu MYSQL está configurada, pode ser outra como: 3306)
spring.datasource.username= 'seu usuario'
spring.datasource.password= 'sua senha'
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

🧪 Como Executar o Projeto Localmente

✅ Pré-requisitos

Java 23
Maven
MySQL 8+
IDE (IntelliJ, VSCode, Eclipse etc.)

🚀 Passos
Clone o repositório:

git clone https://github.com/Danilo-tec-2003/Sistema-imobiliario.git
cd Sistema-imobiliario
Configure o banco como mostrado acima.

Compile o projeto:
./mvnw clean install

Execute o projeto:
./mvnw spring-boot:run

Acesse no navegador:
http://localhost:8080
