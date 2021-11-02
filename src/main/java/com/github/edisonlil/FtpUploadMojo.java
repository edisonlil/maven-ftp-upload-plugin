package com.github.edisonlil;

import com.github.edisonlil.properties.PluginProperties;
import com.github.edisonlil.util.FileUtil;
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

    Log log = getLog();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {


        log.info("GenerateDocsMojo 读取配置信息：\n"+properties.toString());


        FtpClient ftpClient = createFtpClient();

        //基础项目目录
        File baseDir = project.getBasedir();

        if(properties.getRootPath() == null){
            properties.setRootPath(baseDir.getPath());
        }

        if(ftpClient.hasDir(properties.getFtpRemoteDir())){
            ftpClient.delDir(properties.getFtpRemoteDir());
        }

        log.info("maven-ftp-upload-plugin 开始上传文件");

        try {
            String targetFilePath = FileUtil.newFile(properties.getRootPath(),properties.getTargetFile()).getPath();
            ftpClient.upload(properties.getFtpRemoteDir(),properties.getRootPath(),targetFilePath);
        }catch (Exception e){
            ftpClient.close();
            throw new  MojoFailureException("文件上传失败: "+e.getMessage());
        }finally {
            ftpClient.close();
        }

        log.info("maven-ftp-upload-plugin 文件上传成功");
    }


    public FtpClient createFtpClient(){

       return new FtpClient(properties.getFtpHost(),properties.getFtpPort(),
                properties.getFtpUsername(),properties.getFtpPassword(),properties.getFtpRemoteDir(),log);
    }


}
