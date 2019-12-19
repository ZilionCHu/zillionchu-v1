package com.github.zillionchu.zillionchugenerator.generator.utils;

import com.github.zillionchu.zillionchugenerator.xmlorobject.ExcelCallModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ExcelGenaSqlUtils {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    private static Logger logger = LoggerFactory.getLogger(ExcelGenaSqlUtils.class);

    /**
     * excel导入生成sql脚本工具类
     * @param tableName
     * @param filePath
     * @throws IOException
     */
    public static String  createTable(String tableName,Workbook web,String fileName) throws IOException {

        logger.info("==================createTableMethedStart=================================");
        //读取excel生成对象
        // File files = new File("C:/Users/Lenovo/Desktop/createTable/testExcel.xls");
       // File files = new File(filePath);
       // Workbook workBook = getWorkbok(files);
        // sheet 对应一个工作页
        Sheet sheet = web.getSheetAt(0);
        // 第一行从0开始算
        int rowNumber = sheet.getLastRowNum();
        Row row = null;
        List<ExcelCallModel> list = new LinkedList<ExcelCallModel>();
        for (int i = 1; i <= rowNumber; i++) {
            ExcelCallModel excelCallModel = new ExcelCallModel();
            row = sheet.getRow(i);
            excelCallModel.setFieldNm(row.getCell(0).toString());
            excelCallModel.setFieldSize(row.getCell(1).toString());
            excelCallModel.setFieldDis(row.getCell(2).toString());
            sheet.removeRow(row);
            list.add(excelCallModel);
        }
        String column = null;
        StringBuilder sb = null;
        sb = new StringBuilder(50);
        if (tableName == null || tableName.equals("")) {
            //用文件名称作为表名
            tableName = fileName.substring(0,fileName.length()-4);
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
        }
        sb.append("\r\ndrop table if exists  ").append(tableName).append(";\r\n");
        sb.append("create table ").append(tableName).append(" ( \r\n");
        System.out.println(tableName);
        boolean firstId = true;
        File file = null;
        int count = 0;
        for (ExcelCallModel f : list) {
            column = f.getFieldNm();
            column = columnToUpperCase(column);
            sb.append(column).append(" "); //拼接字段名称
            String substring = "String";
            //第一個字段id
            if(count==0){
                sb.append("int("+f.getFieldSize().substring(0,f.getFieldSize().length()-2)+")"); //拼接字段大小
            }else {
                if (substring.equals("String")) {
                    sb.append("VARCHAR("+f.getFieldSize().substring(0,f.getFieldSize().length()-2)+")"); //拼接字段大小
                } else {
                    sb.append(substring);//根据需要自行修改
                }
            }
            if (firstId) {//类型转换
                sb.append(" PRIMARY KEY AUTO_INCREMENT ");
                firstId = false;
            }
            //拼接字段描述
            sb.append(" COMMENT"+ "'"+f.getFieldDis()+"'");

            count++;
            int length = list.size();
            if (count < length) {
                sb.append(",\n ");
            }
        }
        String sql = null;
        sql = sb.toString();
        sql = sb.substring(0, sql.length() - 1) +"'"+" )ENGINE =INNODB DEFAULT CHARSET= utf8;\r\n";
        logger.info("==================createTableMethedEnd=================================");
        return sql;

    }

    public static String columnToUpperCase(String column) {
        char[] columnArr = column.toCharArray();
        int index = -1;
        for (int i = 1; i < columnArr.length; i++) {
            if (columnArr[i] >= 'A' && columnArr[i] <= 'Z') {
                index = i;
                break;
            }
        }
        if (index == -1) {
            column = column.toUpperCase();
            return column;
        } else {
            column = (column.substring(0, index) + "_" + columnToUpperCase(column.substring(index))).toUpperCase();
        }

        return column;
    }

    public static Workbook getWorkbok(File file) throws IOException {
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    public static String excelGreateSql(String sql,String filePath) throws IOException {

        File file = new File(filePath);
        logger.info("=================="+"生成sql存放路径，如果不对请修改："+file.getPath()+"==============================");
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
            }
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println("文件路径:" + file.getAbsolutePath());
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        out.write(sql);
        out.flush();
        out.close();

        return "sucess";
    }

}
