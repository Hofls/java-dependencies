# Quick description
Randoop generates bunch of random tests, which are clearly not meant to be maintained by humans.
Example of generated tests:
1. Super weird input parameters:
```
        int int2 = com.github.hofls.javatests.unit.Mathematics.sum((int) (short) 100, (int) '#');
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 135 + "'", int2 == 135);
```
2. Generation was very slow (about a minute), no use of mockito, test makes zero sense:
```
       ProductsService productsService1 = new ProductsService(null);
        try {
            java.lang.String str3 = productsService1.calculateProducts((java.lang.Long) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
```

# Install
* Download randoop, unzip archive
* Set environment variable `setx RANDOOP_JAR "C:\Programs\Randoop\randoop-all-4.2.3.jar"`
    * test: restart console, `echo %RANDOOP_JAR%`

# Generate!
* Generate tests for your `Mathematics` class:
    * `java -Xmx3000m -classpath %RANDOOP_JAR%;C:\job\idea\java-tests\common\build\classes\java\main\; randoop.main.Main gentests --testclass=com.github.hofls.javatests.unit.Mathematics --output-limit=100`
* Minimize generated `ErrorTest` for your `Mathematics` class:
    * `java -cp %RANDOOP_JAR% randoop.main.Main minimize --suitepath=ErrorTest0.java --suiteclasspath=C:\job\idea\java-tests\common\build\classes\java\main\;C:\Users\pleshakov\.m2\repository\junit\junit\4.12\junit-4.12.jar`

# Other interesting stuff
* Generate tests for `java.util.TreeSet`:
    * `java -Xmx3000m -classpath %RANDOOP_JAR%;bin/ randoop.main.Main gentests --testclass=java.util.TreeSet --output-limit=100`
* Get help:
    * `java -classpath %RANDOOP_JAR% randoop.main.Main help`