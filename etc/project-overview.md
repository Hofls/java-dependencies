### Java project overview
* Most big projects should have:
  * Basics - Automatic CI/CD; Way to run project locally; Local/remote debug
  * Junit tests
  * [test-containers](../tests/test-containers)
  * Automatic architecture enforcement, for example [archunit](../code-analysis/archunit)
  * Automatic code analysis, for example [checkstyle](../code-analysis/checkstyle)
  * E2E tests (more at `useful-info` -> `playwright`)
  * Load tests (more at `useful-info` -> `load-testing`)
  * Automatic security audit (more at `useful-info` -> `penetration-testing`)
  * Automated dependency updates – Dependabot / Renovate / Versions (maven plugin)
    * [dependency-scanners](../code-analysis/dependency-scanners)
  * Code coverage enforcement (JaCoCo)
  * Metrics - [actuator](../actuator)
* Project maintenance:
  * After e2e tests, find unused endpoints (more at `useful-info` -> `python/api-usage`)
  * Find slowest endpoints, check metrics (more at `useful-info` -> `actuator-dashboard.html`)
  * Find performance problems in a DB (more at `useful-info` -> `postgresql/devops-queries.md`)
  * Check logs (for ease of search, all errors should be marked with a unique tag like `ERROR_LOG`)
* More info:
  * Repo `useful-info`, file `code-review.md`
  * Repo `useful-info`, file `project-review.md`
