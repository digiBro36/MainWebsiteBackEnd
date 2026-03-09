#!/bin/bash

BASE="http://localhost:8080/api"

echo "================================"
echo "🚀 Backend API Test Starting"
echo "================================"

echo "1️⃣ Login to get JWT token..."

token=$(curl -s -X POST $BASE/auth/login \
-H "Content-Type: application/json" \
-d '{"email":"admin@example.com","password":"P@ssw0rd123"}' | jq -r '.token')

if [ "$token" == "null" ]; then
  echo "❌ Login failed"
  exit 1
fi

echo "✅ Token received"


echo "2️⃣ Creating service..."

service=$(curl -s -X POST $BASE/services \
-H "Content-Type: application/json" \
-H "Authorization: Bearer $token" \
-d '{"title":"SEO","description":"Search engine optimization","price":999.99,"active":true}')

echo $service | jq

serviceId=$(echo $service | jq -r '.id')

echo "✅ Service created: $serviceId"


echo "3️⃣ Listing services..."

curl -s $BASE/services | jq


echo "4️⃣ Updating service..."

curl -s -X PUT $BASE/services/$serviceId \
-H "Content-Type: application/json" \
-H "Authorization: Bearer $token" \
-d '{"title":"SEO Premium","description":"SEO + reporting","price":1200,"active":true}' | jq


echo "5️⃣ Creating lead..."

lead=$(curl -s -X POST $BASE/leads \
-H "Content-Type: application/json" \
-d '{"name":"John Doe","email":"john@test.com","phone":"1234567890","serviceInterested":"SEO","message":"Need SEO"}')

echo $lead | jq

leadId=$(echo $lead | jq -r '.id')

echo "✅ Lead created: $leadId"


echo "6️⃣ Listing leads..."

curl -s $BASE/leads \
-H "Authorization: Bearer $token" | jq


echo "7️⃣ Creating project..."

project=$(curl -s -X POST $BASE/projects \
-H "Content-Type: application/json" \
-H "Authorization: Bearer $token" \
-d '{"title":"Marketing Website","description":"Digital marketing site","clientName":"Acme Corp","imageUrl":"https://example.com/img.jpg","projectUrl":"https://example.com"}')

echo $project | jq

projectId=$(echo $project | jq -r '.id')

echo "✅ Project created: $projectId"


echo "8️⃣ Listing projects..."

curl -s $BASE/projects | jq


echo "9️⃣ Deleting service..."

curl -s -X DELETE $BASE/services/$serviceId \
-H "Authorization: Bearer $token" \
-w "\nHTTP %{http_code}\n"


echo "🔟 Deleting lead..."

curl -s -X DELETE $BASE/leads/$leadId \
-H "Authorization: Bearer $token" \
-w "\nHTTP %{http_code}\n"


echo "================================"
echo "✅ All API tests finished"
echo "================================"
