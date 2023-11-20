* Transaction is not fully reverted after test? 
    * Most likely implementation opens a new transaction (Propagation.REQUIRES_NEW)
    * Fix - write code to clear tables
    * UserRepository.java:
    ```
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        void deleteAll();
    ```
    * BaseTest.java:
    ```
        @Autowired
        private UserRepository userRepository;
        
        @AfterEach
        void clearTables() {
          userRepository.deleteAll();
        }
    ```
