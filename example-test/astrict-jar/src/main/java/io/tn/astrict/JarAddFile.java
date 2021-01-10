package io.tn.astrict;

import java.io.File;

/**
 * @author tn
 * @version 1
 * @ClassName addFile
 * @description 像jar中添加文件
 * @date 2021/1/10 21:46
 */
public class JarAddFile {

    /**
     * 文件
     */
    File filesToAdd;
    /**
     * 文件路径
     */
    String filesToAddRelativePath;

    public File getFilesToAdd() {
        return filesToAdd;
    }

    public void setFilesToAdd(File filesToAdd) {
        this.filesToAdd = filesToAdd;
    }

    public String getFilesToAddRelativePath() {
        return filesToAddRelativePath;
    }

    public void setFilesToAddRelativePath(String filesToAddRelativePath) {
        this.filesToAddRelativePath = filesToAddRelativePath;
    }
}
