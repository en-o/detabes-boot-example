package io.tn.astrict;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.SocketException;
import java.net.UnknownHostException;

@SpringBootApplication
@Controller
public class AstrictJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AstrictJarApplication.class, args);
    }
    private static String macAddressStr = null;

    @ResponseBody
    @GetMapping("getMacAddress")
    public String getMacAddress() throws UnknownHostException, SocketException {
        String macAddress = MacUtil.getMacAddress();
        System.out.println("macAddress:"+macAddress);
        return macAddress;
    }


    @ResponseBody
    @GetMapping("isUse")
    public String isUse() {
        String macAddress =MacUtil.getMacAddress();
        //文件读取
        try {
            String str = ResourceUtil.readUtf8Str("test.txt");
            Console.log("test: {}", str);
            Console.log("macAddress: {}", macAddress);
            String absolutePath = FileUtil.getAbsolutePath("test.txt");
            Console.log("absolutePath: {}", absolutePath);
            if(macAddress.equals(str)){
                return "相同mac,可以运行";
            }
        }catch (Exception e){
            e.printStackTrace();
            //文件写入-FileWriter
            if(null!=macAddress&&macAddress.trim().length()>0){
                //创建文件
//                    File file = ResourceUtils.getFile(); ResourceUtils.CLASSPATH_URL_PREFIX +
                File file = FileUtil.file( "test.txt");
                FileWriter writer = new FileWriter(file);
                writer.write(macAddress);
                return "初次见面";
            }
        }
        return "shutdown";
    }

}
