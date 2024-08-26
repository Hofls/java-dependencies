##### Getting started
* `OAUTH2` - standard for access delegation. Example - login to 3rd party site using github account
* [Add OAUTH app](https://github.com/settings/developers)
    * Homepage URL - http://localhost:8080/
    * Authorization callback URL - http://localhost:8080/login/oauth2/code/github
* Go to application.yml, replace placeholders INSERT_CLIENT_ID_HERE, INSERT_CLIENT_SECRET_HERE
* Execute `gradlew bootRun`
* Open [link](http://localhost:8080/), sign in
    * If you stay logged in to GitHub, you won’t have to re-authenticate (try incognito mode)
    * To go through authorization process again - [revoke all user tokens](https://github.com/settings/developers)

Based on https://spring.io/guides/tutorials/spring-boot-oauth2/