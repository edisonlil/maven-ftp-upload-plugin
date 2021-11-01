# maven-ftp-upload-plugin

### 使用方法

```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.github.edisonlil</groupId>
            <artifactId>maven-generate-docs-plugin</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <configuration>
                <properties>
                    <ftpHost>8.134.53.178</ftpHost>
                    <ftpPort>21</ftpPort>
                    <ftpUsername>admin</ftpUsername>
                    <ftpPassword>edc3000.</ftpPassword>
                    <targetFile>doc\demo</targetFile>
                </properties>
            </configuration>
            <executions>
                <execution>
                    <id>test</id>
                    <goals>
                        <goal>ftp-upload</goal>
                    </goals>
                    <phase>compile</phase>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```