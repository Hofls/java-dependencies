* To apply settings, move them to `%userprofile%/.m2/settings.xml`
* `build_settings.xml` - look for dependencies in different repositories (order matters!)
* `deploy_settings.xml` - build + deploy dependencies to repository
* Explanation:
    * `<server>` - login and password; repository url located at <repository> (linked by id) 
    * `<mirror>` - alternative repository
    * `<pluginRepositories>` - plugins won't be downloaded from `<repositories>`, you have to specify repos in this tag
    * `<altReleaseDeploymentRepository`, `<altSnapshotDeploymentRepository>`:
        * Repo to deploy, makes `<distributionManagement>` in `pom.xml` unnecessary
