# maven-ftp-upload-plugin

### 作者：edison
### 邮箱：edisonlil@163.com


用于maven打包完通过FTP上传文件到指定服务器的插件。

### 安装指南
```xml
<build>
    <plugins>
         <plugin>
            <groupId>com.github.edisonlil</groupId>
            <artifactId>maven-ftp-upload-plugin</artifactId>
            <version>1.0.3-SNAPSHOT</version>
            <configuration>
                <properties>
                    <ftpHost>8.134.53.178</ftpHost>
                    <ftpPort>21</ftpPort>
                    <ftpUsername>admin</ftpUsername>
                    <ftpPassword>edc3000.</ftpPassword>
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
                    <phase>install</phase>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

