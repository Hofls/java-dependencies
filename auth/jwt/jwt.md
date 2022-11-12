#### Info
* `JWT` - JSON Web Token, used to encode and verify claims
* `Claim` - e.g. I am John with ID 1982783, I can use the system without re-authentication for 5 more days.
* Use case: API authentication mechanism
* Great alternative to plain tokens (which require access do db to verify them)
    * https://stackoverflow.com/a/40375745
* Parts, separated by `.`:
    * `Header` (algorithm name, token type)
    * `Payload` (your json)
    * `Signature` (secret)
* Example:
    * eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
* JWT usually located in `Authorization:` header of http request

#### Auth schema
* User enters login and password on frontend
* Frontend sends data to auth service
    * If credentials are correct - auth service generates JWT and signs it with private key
* Frontend sends JWT with each request to any service
    * Services get public key from auth service and cache it
    * Then they use public key to check that JWT is legit (by decrypting it)
