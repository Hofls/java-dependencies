### JWT auth demo
* JWK & JWT [generator (for test purposes)](https://www.scottbrady91.com/tools/jwt)

##### Getting started
* Run `bootRun`
* Open URL - http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
* Click on "Authorize", insert JWT token:
    * `eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjQ0MzllYmE0N2U3MzVlODkyY2Y4ZjRkMWVmY2QwZTRkIn0.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC1zZXJ2ZXIvIiwic3ViIjoibmF0YWxpYSIsImF1ZCI6InRhbWFyYSIsImlhdCI6MTY2ODMyOTExNCwiZXhwIjoyNjY4MzI5NzE0fQ.ny6LlVMWBLpsTTrZtT6fwBGUPdnEbQPgzko0XXrtWXZ73DZ6C73jlPebV41ngnktZYA1dqPnKpR84vrOT45raGW8IunlHgYs2TKRF5-WXRy4Uj8_tcnyDRJgxfaWvkd9RwzcwePfKeSZzH2AZV15GTzW_ogI6OXJwxL4PfGcPRsGAEX8h-8YFRXf_fslgSz-wZd6v5lyV3cGUcMUUIFoTQhjBTBNa9ovbbiiAkXKxll3NjplCu_FF0LyeN57arH1X6UvE5QW1rEYNidYiGg7lzahl-kclz60EAMTVCvQQN8MyuERs2Ad9r3vwKvgC-BuftxL5F7v4-ZgsfBC0u0BUI8pLSdv3zYPF9ljwPfbAYjZVkZYB93if8cNAqbiLMfCHg1eZ5dZhwYle1E2Wj2lU4hofhodkk9VtObh-UEgwVfNVaMnIPeo0KszfWeND5JZZPHmL0MThvAX8OEErLR3dqAMIIrS5ScKCkMZ66ZsA-1yvozbZximG7ZIGd7X5ZNB`
* Execute `GET /demo` request
