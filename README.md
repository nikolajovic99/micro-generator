# 💻 MicroGenerator — IntelliJ IDEA Plugin for Automated Spring Boot Microservices Generation

**MicroGenerator** is an IntelliJ IDEA plugin developed as part of a master’s thesis project.  
It enables automatic generation of Spring Boot microservices based on a YAML configuration file.  
The plugin eliminates repetitive setup work and helps developers focus on business logic instead of boilerplate code.

---

## 🚀 Key Features

- ✅ Generate Spring Boot microservices directly from a YAML specification
- ✅ Automatic creation of:
    - Models
    - DTO classes
    - Repositories
    - Services
    - Controllers
    - Configuration files
- ✅ Supports multiple databases:
    - PostgreSQL
    - MySQL / MariaDB
    - Oracle
    - SQL Server
    - MongoDB
- ✅ Automatically creates REST API endpoints for every model
- ✅ Clean and modular package structure
- ✅ Fully customizable through templates (FreeMarker `.ftl` files)

---

## ⚙️ Installation

### 1️⃣ Install via IntelliJ IDEA
1. Open **IntelliJ IDEA**
2. Navigate to `File > Settings > Plugins`
3. Click the **⚙️ (Settings icon)** → Install Plugin from Disk...
4. Select previously downloaded `micro-generator-1.0.0.zip` file 

---

## 🧩 How to Use

### 1️⃣ Create a YAML configuration file

The YAML file defines the structure and configuration of the microservices.
The `example.yml` file in this repository demonstrates the structure and all supported input options for the generator.

Supported databases:
- PostgreSQL ➡️ postgresql
- MySQL ➡️ mysql
- MariaDB ➡️ mariadb
- Oracle ➡️ oracle
- SQL Server ➡️ sqlserver
- MongoDB ➡️ mongodb

All logging levels are supported:
- INFO
- TRACE
- DEBUG
- WARN
- ERROR
- FATAL

Primitive and wrapper JAVA types are both supported:
`byte, short, int, long, float, double, char, boolean, 
String, Byte, Short, Integer, Long, Float, Double, Character, Boolean`

### 2️⃣ Run the generator

1. Navigate to `Tools`
2. Choose “Generate Microservices from YAML”
3. Select previously created YAML file
4. The plugin will automatically:
   - Validate the YAML file
   - Generate the project structure
   - Create models, DTOs, repositories, services, and controllers
   - Add all defined dependencies and configuration files

### 3️⃣ Run the generated microservice

1. Open the generated project
2. Run the application with:
    ```bash
    ./mvnw spring-boot:run
    ```
    or use the IntelliJ Run ▶️ button
3. The service will be available at defined port
