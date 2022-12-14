# Unit Testing Advanced Lecture

- Why Do We Need Mocking?
    - Example of code to test without mocks (example0)

        ```java
        public class UsernameManipulator {
        
            public String manipulate(String username) {
        
                String input = username.substring(0, 3);
        
                if (input.toLowerCase().contains("a")) {
                    return username.toLowerCase();
                } else {
                    return username.toUpperCase();
                }
            }
        }
        ```

    - Example that need to be tested with external dependencies of class (example1)
- Mockito
    - Its a library to simplify(if used with care) our testing code
    - How Mockito creates mocks for us (example2) ?
        - `Mockito.mock(…)` static initialisation example
        - Annotation-based approach
        - JUnit 5 Extension
- Types of Test Doubles(aka “дублери”) objects (example3):
    - Dummy
    - Stub - it always returns the predefined output regardless of the input.
    - Spy
    - Mock
    - Fake

  [Choosing the Right Test Double](https://tanzu.vmware.com/developer/guides/test-doubles/)

- Mock behaviour setup
    - `when(...).thenReturn(...)`
    - `when(...).thenThrow(...)`
- Argument Matchers
    - manual examples of matchers
    - Mockito lib alternatives of matchers
- Verification
    - mocks reset
    - verify calls to mock
- Argument Capturing
    - Mockito framework example