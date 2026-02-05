* Fix endless liquibase lock:
    ```
    /**
     * Without this code - if pod dies by timeout while running migrations, row in databasechangeloglock will prevent any future changes (until manually removed)
     * Prerequisite: add "server.shutdown: graceful" to application.yml (so app can remove its own lock before shutting down)
     */
    @Configuration
    @Slf4j
    public class LiquibaseConfig {
    
        protected static final String replicaId;
        protected static final Integer lockDeleteTimeout = 360;
    
        static {
            replicaId = UUID.randomUUID().toString();
        }
    
        private static String getLockedByName(){
            return replicaId;
        }
    
        @Bean
        @ConditionalOnProperty(name="spring.liquibase.enabled", havingValue = "true", matchIfMissing = true)
        public SpringLiquibase liquibase(final DataSource dataSource,
                                         @Value("${spring.liquibase.default-schema}") String defaultSchema,
                                         @Value("${spring.liquibase.change-log}") String changeLog) {
            removeDBLock(dataSource, null, lockDeleteTimeout);
            final SpringLiquibase liquibase = new SpringLiquibase();
            liquibase.setChangeLog(changeLog);
            liquibase.setDefaultSchema(defaultSchema);
            liquibase.setDataSource(dataSource);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                removeDBLock(dataSource, getLockedByName(), null);
            }));
            return liquibase;
        }
    
        private void removeDBLock(DataSource dataSource, String lockedBy, Integer lockDeleteTimeout) {
            String query = null;
            if(lockedBy != null) {
                query = format("DELETE FROM DATABASECHANGELOGLOCK WHERE LOCKED=true AND LOCKEDBY = '%s'", lockedBy);
            } else {
                final Timestamp lastDBLockTime = new Timestamp(System.currentTimeMillis() - (lockDeleteTimeout * 1000));
                query = format("DELETE FROM DATABASECHANGELOGLOCK WHERE LOCKED=true AND LOCKGRANTED<'%s'", lastDBLockTime);
            }
            try (Statement stmt = dataSource.getConnection().createStatement()) {
                int updateCount = stmt.executeUpdate(query);
                if(updateCount>0){
                    log.info("Liquibase locks Removed Count: {} .", updateCount);
                }
            } catch (SQLException e) {
                log.error("Error! Remove Liquibase Change Lock threw and Exception. ",e);
            }
        }
    }
    ```