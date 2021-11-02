# maven-ftp-upload-plugin

### 作者：edison
### 邮箱：edisonlil@163.com


用于maven打包完通过FTP上传文件到指定服务器的插件。

## 安装指南
```xml
<build>
    <plugins>
         <plugin>
            <groupId>com.github.edisonlil</groupId>
            <artifactId>maven-ftp-upload-plugin</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <configuration>
                <properties>
                    <ftpHost>127.0.0.1</ftpHost>
                    <ftpPort>21</ftpPort>
                    <ftpUsername>xxx</ftpUsername>
                    <ftpPassword>xxx</ftpPassword>
                    <!-- ftp远程目录 -->
                    <ftpRemoteDir>/${project.artifactId}</ftpRemoteDir>
                    <!-- 本地根目录，默认项目根目录 -->
                    <rootPath>${project.basedir}\target\apidocs</rootPath>
                    <!--  指定文件
                    <targetFile></targetFile>
                    -->
                </properties>
            </configuration>
            <executions>
                <execution>
                    <id>test</id>
                    <goals>
                        <goal>ftp-upload</goal>
                    </goals>
                    <phase>deploy</phase>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## 使用示例

### 1.搭配`maven-javadoc-plugin`使用，项目打包后上传到私服时同时更新线上文档

```xml
<build>
    <plugins>

        <!-- 配置javadoc输出 -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-javadoc-plugin</artifactId>
            <version>2.9.1</version>
            <configuration>
                <aggregate>true</aggregate>
            </configuration>
            <executions>
                <execution>
                    <id>attach-javadocs</id>
                    <goals>
                        <goal>jar</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        <plugin>
            <groupId>com.github.edisonlil</groupId>
            <artifactId>maven-ftp-upload-plugin</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <configuration>
                <properties>
                    <ftpHost>127.0.0.1</ftpHost>
                    <ftpPort>21</ftpPort>
                    <ftpUsername>xxx</ftpUsername>
                    <ftpPassword>xxx</ftpPassword>
                    <ftpRemoteDir>/${project.artifactId}</ftpRemoteDir>
                    <rootPath>${project.basedir}\target\apidocs</rootPath>
                </properties>
            </configuration>
            <executions>
                <execution>
                    <id>test</id>
                    <goals>
                        <goal>ftp-upload</goal>
                    </goals>
                    <phase>deploy</phase>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
