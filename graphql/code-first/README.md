##### Info
* `Code first` - just write code, schema will be generated automatically
* Based on https://developer.okta.com/blog/2020/01/31/java-graphql

##### Run
* 
* Open [embedded playground](http://localhost:8080/gui)

##### Queries
* Food list:
```
{
  foods {
    id,
    isGood,
    name
  }
}
```

* Add food:
```
mutation {
  saveFood(food: { name: "Pasta" }) {
    id
    isGood
  }
}
```

* Delete food:
```
mutation {
  deleteFood(id: "2")
}
```