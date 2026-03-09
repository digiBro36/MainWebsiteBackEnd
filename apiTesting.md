# API Testing Guide (copy/paste)

This document shows how to run the backend locally, verify it is working, and test the key API endpoints using `curl`. Copy and paste the commands below.

---

## 1) Prerequisites

- **Java 17** installed (use `java -version` to confirm)
- **Maven** installed (`mvn -v`)
- **MongoDB** running locally (default: `mongodb://localhost:27017`)

If you don't have MongoDB installed, follow: https://www.mongodb.com/docs/manual/installation/

---

## 2) Configure the backend

Open `src/main/resources/application.properties` and ensure these values are set:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/marketingDB
server.port=8080
app.jwt.secret=change-me-to-a-secure-random-string
app.jwt.expiration-ms=86400000
```

> ✅ **Important:** Replace `app.jwt.secret` with a strong random string before using this in production.

---

## 3) Build & Run the backend

```bash
cd /home/N3xtharVory4x/MarketingWebsiteBackend
mvn clean package
mvn spring-boot:run
```

If successful, the API should be reachable at `http://localhost:8080/api`.

---

## 4) Verify the server is running

```bash
curl -s -o /dev/null -w "%{http_code}\n" http://localhost:8080/api/services
```

You should get `200` (even if the response is an empty array `[]`).

---

## 5) Create an admin user (Register)

```bash
curl -s -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{ "name": "Admin User", "email": "admin@example.com", "password": "P@ssw0rd123", "role": "ADMIN" }'
```

This returns a JSON object with a `token` field.

---

## 6) Login to get a JWT

```bash
curl -s -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{ "email": "admin@example.com", "password": "P@ssw0rd123" }'
```

Save the token into a shell variable (copy/paste the actual token):

```bash
token="<PASTE TOKEN HERE>"
```

---

## 7) Test public endpoints (no token required)

### List services

```bash
curl -s http://localhost:8080/api/services | jq
```

### List projects

```bash
curl -s http://localhost:8080/api/projects | jq
```

### Create a lead (contact form)

```bash
curl -s -X POST http://localhost:8080/api/leads \
  -H "Content-Type: application/json" \
  -d '{ "name": "Jane Doe", "email": "jane@domain.com", "phone": "123-456-7890", "serviceInterested": "SEO", "message": "Tell me more" }' | jq
```

---

## 8) Test protected admin endpoints (requires JWT)

### Create a service

```bash
curl -s -X POST http://localhost:8080/api/services \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $token" \
  -d '{ "title": "SEO", "description": "Search engine optimization", "price": 999.99, "active": true }' | jq
```

### Update a service (replace <SERVICE_ID>)

```bash
curl -s -X PUT http://localhost:8080/api/services/<SERVICE_ID> \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $token" \
  -d '{ "title": "SEO", "description": "SEO + reporting", "price": 1099.99, "active": true }' | jq
```

### Delete a service (replace <SERVICE_ID>)

```bash
curl -s -X DELETE http://localhost:8080/api/services/<SERVICE_ID> \
  -H "Authorization: Bearer $token" -w "\nHTTP %{http_code}\n"
```

### List leads (admin only)

```bash
curl -s http://localhost:8080/api/leads \
  -H "Authorization: Bearer $token" | jq
```

### Delete a lead (replace <LEAD_ID>)

```bash
curl -s -X DELETE http://localhost:8080/api/leads/<LEAD_ID> \
  -H "Authorization: Bearer $token" -w "\nHTTP %{http_code}\n"
```

### Create a project

```bash
curl -s -X POST http://localhost:8080/api/projects \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $token" \
  -d '{ "title": "Website Redesign", "description": "New marketing website", "clientName": "Acme Corp", "imageUrl": "https://example.com/img.jpg", "projectUrl": "https://example.com" }' | jq
```

---

## 9) How to verify “all the points”

To verify the main features work, ensure the following flows succeed without errors:

1. **Auth**: Register -> Login -> Use token
2. **Leads**: Create lead (public), then list/delete leads (admin)
3. **Services**: Create/update/delete services (admin) and list services (public)
4. **Projects**: Create/update/delete projects (admin) and list projects (public)

If any request returns `401` or `403`, double check the token and the `Authorization: Bearer <token>` header.

---

## 10) Helpful tips

- Use `jq` to pretty-print JSON: https://stedolan.github.io/jq/
- If you see errors in the backend, review the console logs where `mvn spring-boot:run` is running.
- You can use Postman or Insomnia for a GUI API test experience.

---

✅ You can now copy/paste this file directly into your own notes or CI scripts.
