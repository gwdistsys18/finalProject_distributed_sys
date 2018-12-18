#  	API

## User Authentication
* Log in
```
POST /api/login
```

Params

```
json
{
    "username":String ,
    "password":String
}
```

Return
```
{
    "code": 0,
    "msg": "success",
    "data": {
        
    }
}
```

* Sign up
```
POST /api/signup
```

Params

```
json
{
    "username":String ,
    "password":String
}
```

Return
```
{
    "code": 0,
    "msg": "success",
    "data": {
        
    }
}
```

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
        
    }	
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
{
    "code": 0,
    "msg": "success",
    "data": {
        "firstName": String
        "lastName": String
        "nickName": String
        "birthDate": String
        "gender": String
        "college": String
        "major": String
        "phoneNumber": String
    }
}
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
{
    "code": 0,
    "msg": "success",
    "data": {
        
    }
}
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
{
    "code": 0,
    "msg": "success",
    "data": {
        "firstName": String
        "lastName": String
        "nickName": String
        "birthDate": String
        "gender": String
        "college": String
        "major": String
        "phoneNumber": String
    }
}
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
{
    "code": 0,
    "msg": "success",
    "data": {
        "firstName": String
        "lastName": String
        "nickName": String
        "birthDate": String
        "gender": String
        "college": String
        "major": String
        "phoneNumber": String
    }
}
```

* Find All personal infomation (Reserved, don't Use this function)

```
GET /api/personalInfo/findAll
```

Parameters

```
none
```

Return
```
TBD
```

