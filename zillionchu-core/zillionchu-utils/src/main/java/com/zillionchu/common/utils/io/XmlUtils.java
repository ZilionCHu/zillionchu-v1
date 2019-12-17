package com.zillionchu.common.utils.io;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-05-24 16:14
 * @Description:
 */
public class XmlUtils {

    private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


    /**
     * @param filePath
     * @return
     */
    public static final Document parseFile(String filePath) {

        return parseFileThrowException(new File(filePath));

    }

    /**
     * @param file
     * @return
     */
    public static final Document parseFileThrowException(File file) {
        FileInputStream fileInputStream = null;
        Document var3 = null;

        try {
            fileInputStream = new FileInputStream(file);
            Document parse = getXMLBuilder().parse(fileInputStream);
            var3 = parse;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }

        return var3;
    }


    /**
     * @return
     */
    public static final DocumentBuilder getXMLBuilder() {

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;

    }

}
