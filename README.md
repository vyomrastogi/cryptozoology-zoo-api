# Cyrtozoology Zoo REST API


## API Specifications

**Resource Summary**



| URI                                                | HTTP Method |   HTTP Status   | Description                                           |
|----------------------------------------------------|-------------|-----------------|-------------------------------------------------------|
| domain.com/api/zoo/animals               		     | POST        |      201 CREATED| Add animal to Zoo and return new animal               |
| domain.com/api/zoo/animals                         | GET         |   200 OK        | Return the list of animals.                           |
| domain.com/api/zoo/animals/{name}/treat            | PUT         |      200 OK     | Gives treat to animal and makes animal happy.         |
| domain.com/api/zoo/animals/{name}/habitat/{habitat}| PUT         |      200 OK     | Updates habitat and returns animal with mood updated  |
| domain.com/api/zoo/animals?mood={mood}&type={type} | GET         |      200 OK     | Return the list of animals matching search criteria   |
| domain.com/api/zoo/habitats?empty={isEmpty}        | GET         |      200 OK     | Returns the list of habitats matching search criteria |



---
**POST /api/zoo/animals  **

Request Body:
```json
{
    "name": "Lion",
    "type": "walking"   
}
```

Response Body:
```json
{
    "id": "812e2132-cffa-4bb6-8d17-b13c16b2c9b3",
    "name": "Lion",
    "type": "walking",

}
```
---
