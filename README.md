# Create a deployable war file

The first step in producing a deployable war file is to provide a **SpringBootServletInitializer** subclass and override its configure method. This makes use of Spring Framework’s Servlet 3.0 support and allows you to configure your application when it’s launched by the servlet container. Typically, you update your application’s main class to extend **SpringBootServletInitializer**:

```java
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
```

The next step is to update your build configuration so that your project produces a **war** file rather than a jar file. If you’re using **Maven** and using **spring-boot-starter-parent** (which configures Maven’s war plugin for you) all you need to do is modify **pom.xml** to change the packaging to war:

```xml
<packaging>war</packaging>
```

If you’re using **Gradle**, you need to modify **build.gradle** to apply the war plugin to the project:

```groovy
apply plugin: 'war'
```

The final step in the process is to ensure that the embedded servlet container doesn’t interfere with the servlet container to which the war file will be deployed. To do so, you need to mark the embedded servlet container dependency as provided.

If you’re using **Maven**:

```xml
<dependencies>
    <!-- … -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    <!-- … -->
</dependencies>
```

And if you’re using **Gradle**:

```groovy
dependencies {
    // …
    providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    // …
}
```
