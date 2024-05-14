# Restaurant Reservation System

O Restaurant Reservation System é uma aplicação desenvolvida para facilitar a criação de reservas em restaurantes e gerenciar os comentários dos usuários sobre os restaurantes frequentados. A aplicação é construída com base nos princípios da Clean Architecture, implementando testes de unidade para garantir a confiabilidade do sistema.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Maven
- Docker
- Docker Compose
- Java 17

## Compilando o Projeto

Para compilar a aplicação, execute o seguinte comando Maven:

```bash
mvn build
```

## Testando o Projeto

Para executar os testes de unidade, utilize o seguinte comando Maven:

```bash
mvn test
```

## Construindo a Imagem Docker

Para criar uma imagem Docker da aplicação, execute o seguinte comando:

```bash
docker build -t backend:dev -f ./Dockerfile .
```

## Executando o Contêiner PostgreSQL

Para iniciar o contêiner PostgreSQL necessário para a aplicação, utilize o Docker Compose:

```bash
docker-compose -f docker-compose.yaml up -d
```

Após a execução desses comandos, o sistema estará pronto para ser executado localmente.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

