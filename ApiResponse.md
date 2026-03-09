./api-test.sh                        
================================
🚀 Backend API Test Starting
================================
1️⃣ Login to get JWT token...
✅ Token received
2️⃣ Creating service...
{
  "id": "69af0327534342369248fa86",
  "title": "SEO",
  "description": "Search engine optimization",
  "price": 999.99,
  "active": true
}
✅ Service created: 69af0327534342369248fa86
3️⃣ Listing services...
[
  {
    "id": "69af0327534342369248fa86",
    "title": "SEO",
    "description": "Search engine optimization",
    "price": 999.99,
    "active": true
  }
]
4️⃣ Updating service...
{
  "id": "69af0327534342369248fa86",
  "title": "SEO Premium",
  "description": "SEO + reporting",
  "price": 1200.0,
  "active": true
}
5️⃣ Creating lead...
{
  "id": "69af0328534342369248fa87",
  "name": "John Doe",
  "email": "john@test.com",
  "phone": "1234567890",
  "serviceInterested": "SEO",
  "message": "Need SEO",
  "createdAt": "2026-03-09T17:28:08.515640238Z"
}
✅ Lead created: 69af0328534342369248fa87
6️⃣ Listing leads...
[
  {
    "id": "69af0328534342369248fa87",
    "name": "John Doe",
    "email": "john@test.com",
    "phone": "1234567890",
    "serviceInterested": "SEO",
    "message": "Need SEO",
    "createdAt": "2026-03-09T17:28:08.515Z"
  }
]
7️⃣ Creating project...
{
  "id": "69af0329534342369248fa88",
  "title": "Marketing Website",
  "description": "Digital marketing site",
  "clientName": "Acme Corp",
  "imageUrl": "https://example.com/img.jpg",
  "projectUrl": "https://example.com"
}
✅ Project created: 69af0329534342369248fa88
8️⃣ Listing projects...
[
  {
    "id": "69af024e534342369248fa85",
    "title": "Marketing Website",
    "description": "Digital marketing site",
    "clientName": "Acme Corp",
    "imageUrl": "https://example.com/img.jpg",
    "projectUrl": "https://example.com"
  },
  {
    "id": "69af0329534342369248fa88",
    "title": "Marketing Website",
    "description": "Digital marketing site",
    "clientName": "Acme Corp",
    "imageUrl": "https://example.com/img.jpg",
    "projectUrl": "https://example.com"
  }
]
9️⃣ Deleting service...

HTTP 204
🔟 Deleting lead...

HTTP 204
================================
✅ All API tests finished
================================

 Mon  9 Mar - 22:58  ~ 
 @N3xtharVory4x
