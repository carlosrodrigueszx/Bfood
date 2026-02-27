# 🥘 Bfood

📌 **Projeto Backend Java** — API para registrar itens do cardápio e histórico de pedidos  
Feito com foco em JPA/Hibernate, arquitetura em camadas e boas práticas de backend.

---

## 🚀 Descrição

O **Bfood** é uma API backend desenvolvida em **Java** que gerencia:

- Itens de um cardápio
- Histórico de pedidos

O projeto foi construído com foco em aprendizado e aplicação de conceitos essenciais de desenvolvimento backend, tais como:

- Persistência com **JPA** e **Hibernate**
- Estruturação de dados em camadas
- Versionamento com Git
- Construção de lógica de negócios
- Boas práticas de código

---

## 🛠 Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

- 🔹 **Java 17**
- 🔹 **JPA** (Java Persistence API)
- 🔹 **Hibernate** (ORM)
- 🔹 **Maven** (gerenciamento de dependências)
- 🔹 **Banco de dados relacional** (configurável — MySQL/PostgreSQL/H2)
- 🔹 **Arquitetura em camadas**
- 🔹 **Git** (controle de versão)

> Obs: A estrutura e dependências específicas podem ser visualizadas no `pom.xml`.

---

## 📁 Estrutura do Projeto

A estrutura segue o padrão recomendado de camadas:

src/
└── main/
    ├── java/
    │   └── br/
    │       └── com/
    │           └── bfood/
    │               ├── dao/        # Camada de acesso a dados (DAO / persistência)
    │               ├── model/      # Entidades do domínio
    │               ├── service/
    │               │   └── teste/ 
    │               └── utils/      # Classes utilitárias
    │
    └── resources/
        └── application.properties  # Configurações da aplicação

> Essa estrutura facilita **escala, manutenção e testes**, e é um padrão usado em APIs Java modernas.

---

## 🧪 Funcionalidades

As principais features implementadas incluem:

- 📌 CRUD de itens do cardápio  
- 📌 Registro de pedidos e histórico  
- 📌 Persistência com JPA e Hibernate  
- 📌 Modelos/entidades representando domínio real  
- 📌 Camadas separadas para controller, serviço e persistência  

---
