package com.github.edisonlil;

import com.github.edisonlil.properties.PluginProperties;
import com.github.edisonlil.util.FtpClient;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import javax.inject.Inject;
import java.io.File;

/**
 * FTP 上传插件
 * @author edison
 * @since 2021/11/01 15:07
 */
@Mojo(name = "ftp-upload")
public class FtpUploadMojo extends AbstractMojo {

    @Inject
    private MavenProject project;

    /**
     * 插件配置信息
     */
    @Parameter(name = "properties")
    PluginProperties properties;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        Log log = getLog();

        log.info("GenerateDocsMojo 读取配置信息：\n"+properties.toString());

        //基础项目目录
        File baseDir = project.getBasedir();

        FtpClient ftpClient = new FtpClient(properties.getFtpHost(),properties.getFtpPort(),
                properties.getFtpUsername(),properties.getFtpPassword(),properties.getFtpRemoteDir(),log);

        if(properties.getRootPath() == null){
            properties.setRootPath(baseDir.getPath());
        }

        log.info("Start upload file...");
        try {
            boolean ok = ftpClient.upload(properties.getRootPath()+"/"+properties.getTargetFile());
            if (!ok){
                throw new  MojoFailureException("文件上传失败");
            }
        }catch (Exception e){
            ftpClient.close();
        }finally {
            ftpClient.close();
        }

    }

}
