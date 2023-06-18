# Java Agent

> Detect suppressed exceptions in unit tests.

### Assemble

```bash
gradlew assemble
```

This will create the Java Agent `.jar` file: [JavaAgent.jar](build/libs/JavaAgent.jar)

### Test

- ❌ **Without** Java Agent: the exception is swallowed.
  ```bash
  gradlew test
  ```
- ✅ **With** Java Agent: the exception is rethrown.
  ```bash
  gradlew test -Pjava_agent=true
  ```

### Credits

- [@vRallev](https://github.com/vRallev) ~ [Chasing Swallowed Exceptions](https://developer.squareup.com/blog/chasing-swallowed-exceptions/)
- [Java Instrumentation APIs](https://docs.oracle.com/javase/8/docs/api/java/lang/instrument/package-summary.html)
