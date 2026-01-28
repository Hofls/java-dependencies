### Problem:
* You caught exception, but still get error `UnexpectedRollbackException: Transaction silently rolled back because it has been marked as rollback-only`
* Because `Spring` has proxies around `@Transactional` objects, he noticed exception and marked transaction for rollback
