package io.tn.astrict;


import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/**
 * @author tn
 * @version 1
 * @ClassName IsUseJarUtil
 * @description
 * @date 2021/1/10 19:27
 */
public class JarUtil {


    public static void updateJarFile(File srcJarFile, boolean update, List<JarAddFile> filesToAdd) throws IOException {

        File tmpJarFile = File.createTempFile("tempJar", ".tmp");
        JarFile jarFile = new JarFile(srcJarFile);
        boolean jarUpdated = false;
        List<String> fileNames = new ArrayList<String>();

        try {
            JarOutputStream tempJarOutputStream = new JarOutputStream(new FileOutputStream(tmpJarFile));
            try {
                // Added the new files to the jar.
                for (int i = 0; i < filesToAdd.size(); i++) {
                    File file = filesToAdd.get(i).filesToAdd;
                    String fileRelativePath = filesToAdd.get(i).filesToAddRelativePath;
                    FileInputStream fis = new FileInputStream(file);
                    try {
                        byte[] buffer = new byte[1024];
                        int bytesRead = 0;
                        JarEntry entry = new JarEntry(fileRelativePath+file.getName());
                        fileNames.add(entry.getName());
                        tempJarOutputStream.putNextEntry(entry);
                        while ((bytesRead = fis.read(buffer)) != -1) {
                            tempJarOutputStream.write(buffer, 0, bytesRead);
                        }
                    } finally {
                        fis.close();
                    }
                }

                // Copy original jar file to the temporary one.
                Enumeration<?> jarEntries = jarFile.entries();
                while (jarEntries.hasMoreElements()) {
                    JarEntry entry = (JarEntry) jarEntries.nextElement();
                    /*
                     * Ignore classes from the original jar which are being
                     * replaced
                     */
                    String[] fileNameArray = (String[]) fileNames
                            .toArray(new String[0]);
                    Arrays.sort(fileNameArray);
                    if (Arrays.binarySearch(fileNameArray, entry.getName()) < 0) {
                        InputStream entryInputStream = jarFile
                                .getInputStream(entry);
                        tempJarOutputStream.putNextEntry(entry);
                        byte[] buffer = new byte[1024];
                        int bytesRead = 0;
                        while ((bytesRead = entryInputStream.read(buffer)) != -1) {
                            tempJarOutputStream.write(buffer, 0, bytesRead);
                        }
                    } else if (!update) {
                        throw new IOException(
                                "Jar Update Aborted: Entry "
                                        + entry.getName()
                                        + " could not be added to the jar"
                                        + " file because it already exists and the update parameter was false");
                    }
                }

                jarUpdated = true;
            } catch (Exception ex) {
                System.err.println("Unable to update jar file");
                tempJarOutputStream.putNextEntry(new JarEntry("stub"));
            } finally {
                tempJarOutputStream.close();
            }

        } finally {
            jarFile.close();
            if (!jarUpdated) {
                tmpJarFile.delete();
            }
        }
        if (jarUpdated) {
            srcJarFile.delete();
            tmpJarFile.renameTo(srcJarFile);
        }

    }

    public static String getJarPath() {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String os = System.getProperty("os.name");
        if(path.contains("!")) {
            path = path.substring(0,path.indexOf("!"));
        }
        String substring = path.substring(0,path.indexOf(":"));
        if("jar".equalsIgnoreCase(substring)){
            path = path.substring(path.indexOf(":")+1);
        }
        if ("file".equalsIgnoreCase(substring)) {
            path = path.substring(path.indexOf(":")+1);
        }
        if(os.toLowerCase().startsWith("win")){
            path = path.substring(1).replace("/","\\");
        }
        return path;
    }

}
