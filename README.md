```markdown
# 🚀 Assignment Incident Management API

A Spring Boot REST API for managing incidents with severity levels, backed by MongoDB and containerized using Docker and Docker Compose.

---

## 🛠 Tech Stack

- Java 17  
- Spring Boot  
- MongoDB  
- Docker & Docker Compose  
- Mongo Express  

---

## 🐳 Docker Setup

### 🔧 Pre-requisites

- Docker installed  
- Docker Compose (v1 or v2)  


## 📦 How to Build and Run

### Using Docker Compose v2

```
```bash
docker compose up
```
### Using Docker Compose v1

```bash
docker-compose up
```

> 📝 This will build the Spring Boot application, start MongoDB, and launch Mongo Express.

---

## 🌐 Accessing the Services

* **Backend API**: [http://localhost:8080](http://localhost:8080)

* **Mongo Express UI**: [http://localhost:8081](http://localhost:8081)
  Credentials:

  * Username: `admin`
  * Password: `password`

* **MongoDB Details**:

  * Host: `localhost`
  * Port: `27017`
  * Username: `admin`
  * Password: `password`
  * Database: `assignment`

> Spring Boot is configured to connect using the URI:
> `mongodb://admin:password@mongodb:27017/assignment`

---

## 🧪 API Endpoints

### ✅ `GET /incidents`

* Fetch all incidents.

### ✅ `POST /incidents`

* Create a new incident.
* Sample JSON body:

```json
{
  "title": "Memory leak",
  "description": "Memory usage increasing rapidly",
  "severity": "high"
}
```

### ✅ `DELETE /incidents/{id}`

* Delete an incident by its ObjectId.

---

## 🧹 Clean Up

To stop and remove all containers, networks, and volumes:

### Docker Compose v2

```bash
docker compose down -v
```

### Docker Compose v1

```bash
docker-compose down -v
```

To remove unused Docker resources:

```bash
docker system prune
```
