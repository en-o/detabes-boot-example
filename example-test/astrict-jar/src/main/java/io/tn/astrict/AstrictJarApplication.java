package io.tn.astrict;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class AstrictJarApplication {

    static String property = System.getProperty("user.home");

    public static void main(String[] args) throws Exception {
        System.out.println(bindingMachine());
        SpringApplication.run(AstrictJarApplication.class, args);
    }

    /**
     *  启动后都配置读不到，直接在jar中生产文件。
     *  因为第二次启动就不会出现读不到的问题！
     * @return
     * @throws IOException
     */
    public static String bindingMachine() throws Exception {
        String jarPath = JarUtil.getJarPath();
        String macAddress = MacUtil.getMacAddress();
        //文件读取
        try {
            // 查询项目中是否有这个文件
            String str = ResourceUtil.readUtf8Str("test.txt");
            if (null != str && str.length() > 0) {
                if (SecureUtil.md5(macAddress).equals(str)) {
                    return "jar正确运行!";
                }
            }
        } catch (Exception e) {
            if (null != macAddress && macAddress.trim().length() > 0) {
                //创建文件
                List<JarAddFile> jarAddFiles = new ArrayList<>();

                FileWriter writer = new FileWriter(property + "/test.txt");
                File file = writer.write(SecureUtil.md5(macAddress));
                //判断是部署启动
                String isJarUp = AstrictJarApplication.class.getResource("AstrictJarApplication.class").toString();
                String substring = isJarUp.substring(0, isJarUp.indexOf(":"));
                if ("jar".equalsIgnoreCase(substring)) {
                    JarAddFile jarAddFile = new JarAddFile();
                    jarAddFile.setFilesToAdd(file);
                    jarAddFile.setFilesToAddRelativePath(MacUtil.win2Linux("BOOT-INF/classes/"));
                    jarAddFiles.add(jarAddFile);
                    JarUtil.updateJarFile(new File(jarPath), true, jarAddFiles);
                }
                return "jar成功绑定本机!";
            }
        }
        throw new RuntimeException("当前jar只能在本机上使用!");
    }

}
