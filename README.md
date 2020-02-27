

# Desafio Técnico de Backend

- Identificar, documentar e implementar uma API Rest que possa ser utilizada pelo desenvolvedor Front-End para desempenhar as tarefas de uma aplicação. 
- Na carga de dados por arquivo o usuário poderá subir planilhas de até 5 milhões de linhas.
- A implementação dos serviços deverá ser feita utilizando a linguagem de programação Java.
- Considere que o seu time trabalha com integração contínua e entrega contínua e portanto você deverá disponibilizar, 
além do código fonte, todos os artefatos necessários para que estas práticas sejam feitas de forma apropriada.
- <b>Por razões de simplificação, você não precisa implementar a inserção de lojas (upload) e o crud de cliente. Ou seja sua API só disponibilizará entrada de lojas via crud e entrada de clientes via csv.</b>

## Instalação

-   Clonando o repositório

```
git clone https://gitlab.com/FaelDi/gfn_backend_challenge_rafael-dias.git
```

-   Instalando Java

    * [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) 

-   Instalando mysql


    * [Windows](https://dev.mysql.com/downloads/file/?id=492455/) 
    * [macOS](https://dev.mysql.com/downloads/file/?id=492745) 
    * [Ubuntu](https://dev.mysql.com/downloads/file/?id=492457) 
    

-   Configurando o acesso ao MySQL
    
Arquivo

```
src/main/resources/application.properties
```

Altere de acordo com seu banco de dados e acesso
```
spring.datasource.url=jdbc:mysql://localhost:3306/<b>SEUBANCODEDADOS</b>?useSSL=false
spring.datasource.username=<b>SEUUSUARIO</b>
spring.datasource.password=<b>SUASENHA</b>
```
- O script SQL a ser usado para criar as tabelas

```
   CREATE TABLE `SEUBANCODEDADOS`.`customers` (

        `name` VARCHAR(255) NOT NULL,
        `city` VARCHAR(255) NULL,
        `state` VARCHAR(45) NULL,
        `latitude` FLOAT,
        `longitude` FLOAT,
        PRIMARY KEY (`name`));

    CREATE TABLE `SEUBANCODEDADOS`.`stores` (

        `name` VARCHAR(255) NOT NULL,
        `city` VARCHAR(255) NULL,
        `state` VARCHAR(45) NULL,
        `latitude` FLOAT,
        `longitude` FLOAT,
        `revenue` FLOAT,
        PRIMARY KEY (`name`));

```

## Uso

```
http://localhost:8080/
```

## Documentação da API REST 

```
https://documenter.getpostman.com/view/1865718/SzKYNcEa?version=latest
```

## Implantação
PS: não consegui gerar a imagem usando mysql
descrição para gerar imagem de projeto sem mysql


- Gerando a imagem do projeto

Utilizando a IDE IntelliJ abra o arquivo pom.xml, gere o projeto, click em maven no canto direito
selecione clean e install e rode, isso irá gerar os arquivos .jar necessários para implantação da aplicação no Docker.
Insira a tag no arquivo pom.xml, após plugin

```

<build>
    
      <plugins> 
       <plugin>
        ...
       </plugin>
      </plugins>
    <finalName>
        docker-spring-boot
    </finalName>
  </build>
```

- Instalando Docker 
 
```
https://docs.docker.com/docker-for-mac/install/
```

- Verifique se o Docker está rodando

- Crie no projeto um arquivo chamado 

```
Dockerfile
```

- Insira os seguintes comandos

```
FROM openjdk:8
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8085 
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]

```

- Abra o terminal na pasta do seu projeto e insira os seguintes comandos para gerar a imagem do seu projeto no docker

```
 docker build -f Dockerfile -t docker-spring-boot .
```

- Verificando se a imagem foi criada

digite no terminal

```
 docker images
```

como resposta terá a confirmação da imagem criada da sua aplicação

```
 REPOSITORY           TAG                 IMAGE ID            CREATED             SIZE
docker-spring-boot   latest              8543b21711f6        17 seconds ago      552MB
```

- Rodando a imagens docker

```
 docker run -p 8085:8085 docker-spring-boot
```


## Desenvolvido com

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Spring Batch](https://spring.io/projects/spring-batch) - Processing large volumes of records
* [ Lombok ](https://projectlombok.org/) - automatically plugs into your editor and build tools
* [JPA](https://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html) - Java Persistence API
* [Mysql](https://www.mysql.com/) - Database
* [ Maven](https://maven.apache.org/) - Dependency Management


## Agradecimentos

* A equipe da Geofusion por me dar oportunidade de mostrar o quanto sou capaz de aprender sobre novas coisas em um pequeno período de tempo.

