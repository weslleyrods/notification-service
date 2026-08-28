<div align="center">
  <a href="README.pt-br.md">
    <img src="https://img.shields.io/badge/lang-pt--br-green.svg" alt="Português">
  </a>
  <a href="README.md">
    <img src="https://img.shields.io/badge/lang-en-red.svg" alt="English">
  </a>
</div>

# Notification Service

## Resumo
Microsserviço responsável por ouvir eventos da arquitetura e realizar o disparo de notificações assíncronas.
Atualmente, a aplicação atua como um consumidor Kafka, escutando eventos de criação de novos usuários (`user-events`) originados pelo serviço principal de identidade (Spring Secure Identity API).

Ao receber um evento de criação, este serviço simula o preparo e envio de um e-mail de boas-vindas para o usuário, demonstrando uma Arquitetura Orientada a Eventos (EDA).

## Tecnologias Utilizadas

* **Linguagem:** Java 25
* **Framework:** Spring Boot 4
* **Mensageria:** Apache Kafka
* **Ferramentas:** Lombok, Gradle
* **Testes:** JUnit 5

## Estudos Aplicados

Este projeto foi desenvolvido com foco na aplicação de conceitos de arquitetura distribuída:

* **Arquitetura Orientada a Eventos (EDA):** Integração assíncrona garantindo o desacoplamento entre serviços. O serviço de identidade não precisa saber como o e-mail é enviado.
* **Mensageria com Kafka:** Consumo de mensagens em tópicos (`user-events`) com serialização/desserialização JSON de forma nativa utilizando `Jackson`.
* **Microservices:** Responsabilidade única de lidar com notificações de forma escalável e independente.

## Instalação e Execução

### Pré-requisitos
* Apache Kafka rodando localmente (pode ser inicializado via Docker no projeto `spring-secure-identity-api`).
* Java 25.

### Passo 1: Dependência (Infraestrutura)
Este serviço não possui um arquivo `docker-compose.yml` próprio, pois ele aproveita a infraestrutura já declarada no microsserviço principal.
Certifique-se de iniciar o Kafka no projeto `spring-secure-identity-api`:

```bash
# Na pasta do projeto ssi:
docker compose up db kafka -d
```

### Passo 2: Rodando o Projeto

Você pode iniciar o serviço utilizando a sua IDE (IntelliJ/Eclipse) ou executar o comando via Gradle:

```bash
./gradlew bootRun
```

A aplicação subirá na porta padrão (ou na porta configurada) e se conectará automaticamente ao Kafka em `localhost:9092`. 
Ao criar um usuário no serviço principal, você verá no console deste serviço a notificação sendo processada.
