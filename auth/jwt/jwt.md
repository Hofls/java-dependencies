#### Info
* `jwt` - JSON Web Token, used to encode and verify claims
* Great alternative to plain tokens (which require access do db to verify them)
    * https://stackoverflow.com/a/40375745
* Parts, separated by `.`:
    * `Header` (algorithm name, token type)
    * `Payload` (your json)
    * `Signature` (secret)
* Example:
    * eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
