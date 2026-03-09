# Digital Marketing Agency Backend (Spring Boot + MongoDB)

A clean, minimal backend MVP for a digital marketing agency built with **Java 17**, **Spring Boot**, **Spring Security**, **JWT Authentication**, **Spring Data MongoDB**, and **Lombok**.

This project is designed to be easy to extend and integrate with a frontend. It provides APIs for admin authentication, lead management, service management, and project/portfolio management.

---

## ✅ What’s Included (MVP)

- **Admin Authentication** (JWT-based)
- **Lead Management** (contact form workflow)
- **Service Management** (CRUD)
- **Project / Portfolio Management** (CRUD)

🔒 **Security**: All admin endpoints are protected using JWT tokens.

---

## 🏗️ Architecture & Folder Structure

This project follows clean architecture principles with a clear separation of concerns:

```
src/main/java/com/digitalmarketing
  ├─ config/            # Security, JWT, and app configuration
  ├─ controller/        # REST controllers (API layer)
  ├─ service/           # Business logic
  ├─ repository/        # MongoDB repositories
  ├─ model/             # Database entity models
  └─ dto/               # Request/response transfer objects
```

---

## 🧩 Database Schema (MongoDB)

**User**

- `id` (string)
- `name` (string)
- `email` (string)
- `password` (string, hashed)
- `role` (string, e.g. `ADMIN`)

**Lead**

- `id` (string)
- `name` (string)
- `email` (string)
- `phone` (string)
- `serviceInterested` (string)
- `message` (string)
- `createdAt` (Instant)

**Service**

- `id` (string)
- `title` (string)
- `description` (string)
- `price` (double)
- `active` (boolean)

**Project**

- `id` (string)
- `title` (string)
- `description` (string)
- `clientName` (string)
- `imageUrl` (string)
- `projectUrl` (string)

---

## �️ Frontend (Next.js)

A premium frontend lives in the `frontend/` folder.

### Run frontend

```bash
cd frontend
npm install
npm run dev
```

The frontend expects the backend API to be available at `NEXT_PUBLIC_API_URL` (default: `http://localhost:8080/api`).

---

## �🚀 Running Locally

### Prereqs

- Java 17
- MongoDB running locally
- Maven

### 1) Configure MongoDB (app settings)

Edit `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/marketingDB
server.port=8080
app.jwt.secret=change-me-to-a-secure-random-string
app.jwt.expiration-ms=86400000
```

🚨 **Important:** Replace `app.jwt.secret` with a strong secret for production.

### 2) Build + Run

```bash
mvn clean package
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 🔐 Auth Flow (JWT)

1. Register admin: `POST /api/auth/register` (returns a token)
2. Login: `POST /api/auth/login` (returns a token)
3. Use the token in subsequent requests:

```
Authorization: Bearer <token>
```

---

## 📚 API Documentation

### Auth

- `POST /api/auth/register`
  - Body: `{ "name", "email", "password", "role" }`
  - Response: `{ "token": "<JWT>" }`

- `POST /api/auth/login`
  - Body: `{ "email", "password" }`
  - Response: `{ "token": "<JWT>" }`

---

### Leads (Contact Form)

- `POST /api/leads` (public)
  - Body: `{ "name", "email", "phone", "serviceInterested", "message" }`

- `GET /api/leads` (admin)

- `DELETE /api/leads/{id}` (admin)

---

### Services

- `GET /api/services` (public)

- `POST /api/services` (admin)
  - Body: `{ "title", "description", "price", "active" }`

- `PUT /api/services/{id}` (admin)

- `DELETE /api/services/{id}` (admin)

---

### Projects

- `GET /api/projects` (public)

- `POST /api/projects` (admin)
  - Body: `{ "title", "description", "clientName", "imageUrl", "projectUrl" }`

- `PUT /api/projects/{id}` (admin)

- `DELETE /api/projects/{id}` (admin)

---

## 🐞 Debugging Tips

- Check the logs for full stack traces (Spring Boot prints errors clearly).
- Ensure MongoDB is running and the URI matches.
- If you get 401, verify the JWT token and that it is sent as `Authorization: Bearer <token>`.
- If you get `Forbidden`, ensure you are using an admin role and that the token contains it.

---

## 🧪 Example API Requests (Postman)

### 1) Register (admin)

```
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "name": "Admin",
  "email": "admin@example.com",
  "password": "password123",
  "role": "ADMIN"
}
```

### 2) Login

```
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "email": "admin@example.com",
  "password": "password123"
}
```

### 3) Create a Service (admin)

```
POST http://localhost:8080/api/services
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "SEO Optimization",
  "description": "Improve search rankings",
  "price": 950.0,
  "active": true
}
```

---

## 🧩 Next Steps (Frontend Integration)

- Use the auth endpoints to store JWT tokens in local storage.
- Call public APIs for services/projects from marketing pages.
- Use protected APIs to build an admin panel (leads, services, projects).
- Add new modules (blogs, testimonials, email integration) in their own controllers/services.

---

If you want, I can also scaffold the React/Next.js frontend for this API.

# To run the backend

export $(grep -v '^#' .env | xargs)
mvn spring-boot:run
