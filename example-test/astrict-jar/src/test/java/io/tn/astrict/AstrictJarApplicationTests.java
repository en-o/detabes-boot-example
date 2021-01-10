package io.tn.astrict;

import cn.hutool.core.io.file.FileWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AstrictJarApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * jar 新增文件
     * @throws IOException
     */
    void addJarFiles() throws IOException {
        String path = "D:\\project\\java\\work\\company\\detabes-boot-example\\example-test\\astrict-jar\\target\\astrict-jar-0.0.1-SNAPSHOT.jar";
        List<JarAddFile> jarAddFiles = new ArrayList<>();
        FileWriter writer = new FileWriter("test.txt");
        File file = writer.write("初次见面111");
        JarAddFile jarAddFile = new JarAddFile();
        jarAddFile.setFilesToAdd(file);
        jarAddFile.setFilesToAddRelativePath("BOOT-INF/classes/");
        jarAddFiles.add(jarAddFile);

        cn.hutool.core.io.file.FileWriter writer1 = new FileWriter("test1.txt");
        File file1 = writer1.write("初次见面111");
        JarAddFile jarAddFile1 = new JarAddFile();
        jarAddFile1.setFilesToAdd(file1);
        jarAddFile1.setFilesToAddRelativePath("BOOT-INF/classes/");
        jarAddFiles.add(jarAddFile1);


        JarUtil.updateJarFile(new File(path), true, jarAddFiles);
    }

//    public static void main(String[] args) throws IOException {
//        String path = "D:\\project\\java\\work\\company\\detabes-boot-example\\example-test\\astrict-jar\\target\\astrict-jar.jar";
//        List<JarAddFile> jarAddFiles = new ArrayList<>();
//        FileWriter writer = new FileWriter("test.txt");
//        File file = writer.write("初次见面111");
//        JarAddFile jarAddFile = new JarAddFile();
//        jarAddFile.setFilesToAdd(file);
//        jarAddFile.setFilesToAddRelativePath("BOOT-INF/classes/");
//        jarAddFiles.add(jarAddFile);
//
//        cn.hutool.core.io.file.FileWriter writer1 = new FileWriter("test1.txt");
//        File file1 = writer1.write("初次见面111");
//        JarAddFile jarAddFile1 = new JarAddFile();
//        jarAddFile1.setFilesToAdd(file1);
//        jarAddFile1.setFilesToAddRelativePath("BOOT-INF/classes/");
//        jarAddFiles.add(jarAddFile1);
//
//
//        JarUtil.updateJarFile(new File(path), true, jarAddFiles);
//    }

}
