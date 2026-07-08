### Problem:
* You caught exception, but still get error `UnexpectedRollbackException: Transaction silently rolled back because it has been marked as rollback-only`
* Because `Spring` has proxies around `@Transactional` objects, he noticed exception and marked transaction for rollback
* Fix - disable rollbacks for problematic method (look at `AddressService`)
* Dead end - trying to force spring to print original exception, so debugging becomes easier
  * No way to do it, OG exception is discarded
