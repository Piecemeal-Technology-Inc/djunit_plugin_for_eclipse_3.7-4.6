# Site has been moved
This site will no longer be updated. Please visit the new site.

new site: [https://girigiri-safe.github.io/djunit_plugin_for_eclipse_3.7-4.6/](https://girigiri-safe.github.io/djunit_plugin_for_eclipse_3.7-4.6/)

# djunit_plugin_for_eclipse_3.7-4.6

djUnit plugin for Eclipse version 3.7 - 4.6

> current version 0.9.1

| eclipse version | code name |
| :-------------- | --------: |
| 3.7             |    Indigo |
| 4.2             |      Juno |
| 4.3             |    Kepler |
| 4.4             |      Luna |
| 4.5             |      Mars |
| 4.6             |      Neon |

for Eclipse 4.7 - 4.18 is [here](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_4.7-4.18/).

Maven Repository: [https://piecemeal-technology-inc.github.io/djunit-maven-repo/](https://piecemeal-technology-inc.github.io/djunit-maven-repo/)

---

## Tips

> Running djUnit with VSCode Java Test Runner. (djUnit 0.9.1 and later)

- Add the followings in your settings.json

```
{
    ...
    "java.test.config": {
        "name": "run test with djunit.",
        "workingDirectory": "${workspaceFolder}",
        "args": [],
        "vmArgs": [
            "-Djava.system.class.loader=jp.co.dgic.testing.common.DJUnitClassLoader" ,
            "-Ddjunit.virtualmock.enable=true",
            "-Ddjunit.asm.version=ASM9",
            "-Ddjunit.target.src.dir=${workspaceFolder}/src/main/java"
        ],
        "sourcePaths": ["${workspaceFolder}/src/main/java"]
    },
    ...
}
```

| VM Arguments              | Value                                       | Default | Required |
| :------------------------ | :------------------------------------------ | :-----: | :------: |
| java.system.class.loader  | jp.co.dgic.testing.common.DJUnitClassLoader |         |   Yes    |
| djunit.virtualmock.enable | true                                        |         |   Yes    |
| djunit.asm.version        | ASM9 or ASM5                                |  ASM9   |    No    |
| djunit.target.src.dir     | path to your source folder                  |         |   Yes    |

<br>
<br>

> Running djUnit with Maven Surefire Plugin. (djUnit 0.9.1 and later)

- Add the followings in your settings.xml or pom.xml

```
  <repositories>
    <repository>
      <id>djunit.repository</id>
      <name>djUnit repository</name>
      <url>https://piecemeal-technology-inc.github.io/djunit-maven-repo/</url>
    </repository>
  </repositories>
```

```
  <dependencies>
    ...
    <dependency>
      <groupId>jp.co.pmtech</groupId>
      <artifactId>djunit</artifactId>
      <version>0.9.1</version>
    </dependency>
    <dependency>
      <groupId>jp.co.pmtech</groupId>
      <artifactId>djunit-asm</artifactId>
      <version>9.1</version>
    </dependency>
    ...
  </dependencies>
```

```
<build>
    <pluginManagement>
      <plugins>
        ...
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>...</version>
          <configuration>
            <includes>
              <include>**/*Test.java</include>
            </includes>
            <argLine>-Djava.system.class.loader=jp.co.dgic.testing.common.DJUnitClassLoader -Ddjunit.coverage.enable=true -Ddjunit.virtualmock.enable=true -Ddjunit.asm.version=ASM9 -Ddjunit.target.src.dir=${project.basedir}\src\main\java</argLine>
          </configuration>
        </plugin>
        ...
      </plugins>
    </pluginManagement>
  </build>

```

<br>
<br>

---

# Release Note

> version 0.9.1

- AppClassLoader compatibility issue fixed for Java9.(Base ClassLoader No Longer from URLClassLoader)
- Improved compatibility with VSCode "java test runner" , Maven and ANT.

Update Site: [https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.1/](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.1/)  
Download: [djunit.jar](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.1/djunit-0.9.1.jar)  
Download Updatesite.zip: [djunit-0.9.1-eclipse3.7.x-updatesite.zip](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.1/djunit-0.9.1-eclipse3.7.x-updatesite.zip)

---

> version 0.9.0

- ASM 3.x, 2.x and 1.5 removed.
- Repackaged ASM 5.x, 9.x. included.
- java8 and java11 supported.

Update Site: [https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.0/](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.0/)  
Download: [djunit.jar](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.0/djunit-0.9.0.jar)  
Download Updatesite.zip: [djunit-0.9.0-eclipse3.7.x-updatesite.zip](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.9.0/djunit-0.9.0-eclipse3.7.x-updatesite.zip)

---

> version 0.8.6

- runnable on eclipse3.7 to 4.6.
- java8 not supported.

Update Site: [https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.8.6/](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.8.6/)  
Download: [djunit.jar](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.8.6/djunit-0.8.6.jar)  
Download Updatesite.zip: [djunit-0.8.6-eclipse3.7.x-updatesite.zip](https://piecemeal-technology-inc.github.io/djunit_plugin_for_eclipse_3.7-4.6/updatesite/0.8.6/djunit-0.8.6-eclipse3.7.x-updatesite.zip)

---
