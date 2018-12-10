#  	API

## User Perference

* Get User Preference By Id

```
GET /api/userpreference/preference/{id}
```

Params

```
none
```

Return

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        
    }
}
```

* Add User Preference

```
POST /api/userpreference/preference/{id}
```

Params

```
none
```

Return

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        
    }
}
```

* Update User Preference

```
PUT http://localhost:8080/api/userpreference/preference
```

Params

```json
{
    "id": Integer,
    "sports": Boolean,
    "music": Boolean,
    "technology": Boolean,
    "politics": Boolean,
    "art": Boolean,
    "literature": Boolean,
    "game": Boolean,
    "movie": Boolean,
    "cooking": Boolean,
    "finance": Boolean
}
```

Return

```
{
    "code": 0,
    "msg": "success",
    "data": {
        
    } q	
}
```

## Personal Info

* Create a personal infomation entry

```
GET /api/personalInfo/create
```

Parameters

```
none
```

Return
```

```

* Delete personal infomation

```
GET /api/personalInfo/delete
```

Parameters

```
none
```

Return
```

```

* Update personal infomation

```
POST /api/personalInfo/update
```

Parameters

```
json
{
    "firstName": String
    "lastName": String
    "nickName": String
    "birthDate": String (Max_Length = 10)
    "gender": String (Max_Length = 1)
    "college": String
    "major": String (Max_Length = 30)
    "phoneNumber": String (Max_Length = 30)
}
```

Return
```

```

* Find self personal infomation

```
GET /api/personalInfo/findSelf
```

Parameters

```
none
```

Return
```

```

* Find All personal infomation (Don't Use Yet)

```
GET /api/personalInfo/findAll
```

Parameters

```
none
```

Return
```

```

