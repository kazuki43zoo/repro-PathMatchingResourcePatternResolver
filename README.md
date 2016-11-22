# repro-PathMatchingResourcePatternResolver

Related with https://jira.spring.io/browse/SPR-13685

## Clone this project

```
$ git clone https://github.com/kazuki43zoo/repro-PathMatchingResourcePatternResolver.git
```

## Build this project

```
$ cd repro-PathMatchingResourcePatternResolver/
$ ./mvnw package
```

## Run this application

```
$ java -jar target/path-demo-0.0.1-SNAPSHOT.jar
```

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.2.RELEASE)

2016-11-22 22:59:41.057  INFO 22287 --- [           main] com.example.PathDemoApplication          : Starting PathDemoApplication v0.0.1-SNAPSHOT on xxxx with PID 22287 (/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar started by xxxx in /private/tmp/repro-PathMatchingResourcePatternResolver)
2016-11-22 22:59:41.061  INFO 22287 --- [           main] com.example.PathDemoApplication          : No active profile set, falling back to default profiles: default
2016-11-22 22:59:41.115  INFO 22287 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@5b37e0d2: startup date [Tue Nov 22 22:59:41 JST 2016]; root of context hierarchy
------resources1---------
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/my/mappers/FooMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes/my/mappers/FooMapper.xml
jar:file:target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes/my/mappers/BarMapper.xml
jar:file:target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes/my/mappers/FooMapper.xml
------resources2---------
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/my/mappers/FooMapper.xml
------resources3---------
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/my/mappers/FooMapper.xml
2016-11-22 22:59:42.048  INFO 22287 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2016-11-22 22:59:42.060  INFO 22287 --- [           main] com.example.PathDemoApplication          : Started PathDemoApplication in 1.634 seconds (JVM running for 1.962)
2016-11-22 22:59:42.066  INFO 22287 --- [       Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@5b37e0d2: startup date [Tue Nov 22 22:59:41 JST 2016]; root of context hierarchy
2016-11-22 22:59:42.067  INFO 22287 --- [       Thread-1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```

## application.properties

```
my.app.test.resources1=classpath*:/**/mappers/*Mapper.xml
my.app.test.resources2=classpath*:/my/**/*Mapper.xml
my.app.test.resources3=classpath:/**/mappers/*Mapper.xml
```

## Result using Spring Boot 1.3.8.RELEASE

```diff
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
-    <version>1.4.2.RELEASE</version>
+    <version>1.3.8.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

```
$ ./mvnw -U clean package
```
```
$ java -jar target/path-demo-0.0.1-SNAPSHOT.jar
```

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.3.8.RELEASE)

2016-11-22 23:06:27.222  INFO 22453 --- [           main] com.example.PathDemoApplication          : Starting PathDemoApplication v0.0.1-SNAPSHOT on xxxx with PID 22453 (/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar started by xxxx in /private/tmp/repro-PathMatchingResourcePatternResolver)
2016-11-22 23:06:27.224  INFO 22453 --- [           main] com.example.PathDemoApplication          : No active profile set, falling back to default profiles: default
2016-11-22 23:06:27.258  INFO 22453 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@5c29bfd: startup date [Tue Nov 22 23:06:27 JST 2016]; root of context hierarchy
------resources1---------
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/my/mappers/FooMapper.xml
------resources2---------
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/my/mappers/FooMapper.xml
------resources3---------
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/my/mappers/BarMapper.xml
jar:file:/private/tmp/repro-PathMatchingResourcePatternResolver/target/path-demo-0.0.1-SNAPSHOT.jar!/my/mappers/FooMapper.xml
2016-11-22 23:06:27.952  INFO 22453 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2016-11-22 23:06:27.961  INFO 22453 --- [           main] com.example.PathDemoApplication          : Started PathDemoApplication in 1.25 seconds (JVM running for 1.544)
2016-11-22 23:06:27.961  INFO 22453 --- [       Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@5c29bfd: startup date [Tue Nov 22 23:06:27 JST 2016]; root of context hierarchy
2016-11-22 23:06:27.962  INFO 22453 --- [       Thread-1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```

