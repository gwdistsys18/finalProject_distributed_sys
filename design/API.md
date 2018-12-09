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

