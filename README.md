# HEMN — Sistema de Gerenciamento de Pedidos

O **HEMN** é um sistema desenvolvido para gerenciar pedidos realizados por clientes, estruturado em uma arquitetura organizada em três camadas principais:

- **database/** — Contém o modelo conceitual e lógico, scripts SQL, diagramas e documentação de dados.
- **backend/** — Aplicação Java (Spring Boot) responsável pela API REST, regras de negócio e persistência em PostgreSQL.
- **frontend/** — (Em desenvolvimento) Interface web que consumirá a API do backend.

Este repositório foi estruturado para separar claramente cada parte do sistema, permitindo fácil manutenção, evolução e compreensão do projeto.

## 📁 Estrutura do Repositório

O projeto está dividido em três diretórios principais: `backend/`, `database/` e `frontend/` (este último ainda em desenvolvimento).  
A seguir, a estrutura utilizada neste README considera apenas *backend* e *database*, conforme solicitado.

## 📁 Estrutura do Repositório

### 📂 `database/` — Modelagem e Scripts SQL

```text
database/
├── diagramas/
│   ├── DER.png
│   ├── Modelo_Conceitual.png
│   └── Modelo_Lógico.png
├── scripts/
│   ├── 01_create_tables.sql
│   ├── 02_insert_data.sql
│   └── 03_constraints.sql
└── README_DATABASE.md
```

### 📂 `backend/` — API REST em Java

```text
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.hemn.api/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.properties
└── pom.xml
```

## 🧩 Integração Geral do Projeto

O projeto HEMN foi estruturado de forma modular, permitindo que cada camada evolua separadamente:

- O **backend** fornece uma API REST robusta e conectada ao banco de dados.
- O **database** garante a base sólida de dados e documentação.
- O **frontend** (em desenvolvimento) irá consumir os endpoints e entregar a interface final.

Essa arquitetura facilita manutenção, expansão e reutilização do código.

## ▶️ Como Executar o Projeto

### 1. ⚙️ Pré-requisitos
- Java 17+
- Maven 3.8+
- PostgreSQL instalado e configurado
- Banco `HEMN` criado
- Usuário `hemn_app` com permissões (conforme definido nos scripts)

### 2. 📦 Configurar o Banco
Execute no PostgreSQL:

1. Criação das tabelas  
2. Inserção dos dados iniciais  
3. Configuração das permissões

Exemplo:
```bash
psql -U postgres -f database/Scripts/CREATE.sql
psql -U postgres -f database/Scripts/INSERT.sql
```

### 3. 📦 Configurar o Backend
No arquivo:
```text
backend/src/main/resources/application.properties
```
Ajuste as credenciais conforme o seu ambiente.

### 4. ▶️ Rodar a Aplicação
Dentro da pasta ```backend/```:
```bash
mvn spring-boot:run
```
A API iniciará normalmente em:
```text
http://localhost:8080
```
