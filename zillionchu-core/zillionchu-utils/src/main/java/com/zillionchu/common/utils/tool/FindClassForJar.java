package com.zillionchu.common.utils.tool;

import java.io.*;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-05-13 11:13
 * @Description:
 */
public class FindClassForJar {

    public static final String path = "D:\\task\\lib"; //jar包父目录
    public static final String keywords = "ActivityExecuterHelpPartiListUtil"; //关键字
    public static void main(String[] args){
        File file = new File(path);
        final Pattern p = Pattern.compile(".+\\.jar$");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(p.matcher(pathname.getPath()).matches()){
                    return true;
                }else{
                    return false;
                }
            }
        });

        search(files);
    }

    private static void search(File[] files){
        try{
            for(File f : files){
                if(f.isDirectory()){
                    search(f.listFiles());
                }else{
                    ZipFile jar = new ZipFile(f);
                    Enumeration enumration = jar.entries();
                    while(enumration.hasMoreElements()){
                        ZipEntry zipEntry = (ZipEntry)enumration.nextElement();

                        InputStreamReader isr = new InputStreamReader(jar.getInputStream(zipEntry));
                        BufferedReader br = new BufferedReader(isr);
                        String line = br.readLine();
                        int line_num = 1;
                        while(null != line){
//                            System.out.println(line);
                            if(line.contains(keywords)){
                                System.out.println(f.getPath() + ","  +zipEntry.getName() + "," + "line number = " + line_num);
                            }
                            line = br.readLine();
                            line_num++;
                        }
                    }
                }
            }
        }catch(ZipException z_e){
            z_e.printStackTrace();
        }catch(IOException io_e){
            io_e.printStackTrace();
        }
    }
}
