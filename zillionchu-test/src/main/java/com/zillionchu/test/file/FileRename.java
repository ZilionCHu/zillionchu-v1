package com.zillionchu.test.file;

import java.io.File;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-09-13 00:12
 * @Description:
 */
public class FileRename {
    private static final String replaceStr = "-(每特教育&每特学院&蚂蚁课堂)-4期";

    private static final String path = "/Users/zillionchu/Downloads/03";


    public static void main(String[] args) {
        reFileName();
    }

    public static void reFileName() {
        File file = new File(path);
        File fs[] = file.listFiles();
        for (int i = 0; i < fs.length; i++) {
            //for (int i = 0; i < 1; i++) {
            System.out.println(fs[i].getName());
            String filename = fs[i].getName();
            String replace = filename.replace(replaceStr, "");
           // File newfile = new File(path + "\\" + replace);
            File newfile = new File(path +"/"+ replace);
            System.out.println(newfile.getName());
            fs[i].renameTo(newfile);
        }

    }

}
