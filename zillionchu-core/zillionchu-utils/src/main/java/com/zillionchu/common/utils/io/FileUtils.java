package com.zillionchu.common.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtils {

    /**
     * 保存文件，路径不存在则创建
     *
     * @param fileData 文件数据
     * @param path     文件路径
     * @return
     * @throws IOException 创建文件异常
     */
    public static Path saveFile(byte[] fileData, Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        return Files.write(path, fileData);
    }


    /**
     * 保存文件，路径不存在则创建
     *
     * @param fileName 文件名
     * @param fileData 文件数据
     * @param filePath 文件路径
     * @return
     * @throws IOException 创建文件异常
     */
    public static Path saveFile(byte[] fileData, String filePath, String fileName) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        return Files.write(Paths.get(path.toString(), fileName), fileData);
    }

    /**
     * 删除文件及子目录
     *
     * @param file
     */
    public static void fileRemove(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                fileRemove(f);
            }
        }
        file.delete();
    }

    public static void main(String[] args) throws IOException {
        saveFile("11212".getBytes(), "D:\\", "out.txt");
    }
}