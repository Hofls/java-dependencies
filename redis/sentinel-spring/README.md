# Sentinel. Hello World!
* Prerequisite: `Sentinel` and `Redis` should be running locally
* How it works:
    * Connect to sentinel, get redis IP address
    * Connect to redis
    
### Etc
* Debug:
    * Set breakpoint on `io.lettuce.core.AbstractRedisClient.getConnection();`; line `if (e instanceof ExecutionException) {`
    * Common exception №1 `RedisConnectionException: Cannot connect to a Redis Sentinel`
    * Common exception №3 `ExecutionException: RedisConnectionException: Cannot provide redisAddress using sentinel for masterId`
        * Means connect to sentinel was successful, but there is no master with this name 
    * Common exception №2 `ExecutionException: ConnectTimeoutException: connection timed out: /172.18.0.2:6379`
        * Means connect to sentinel was successful, you got IP address of redis, but cannot connect to redis
    