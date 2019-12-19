package com.github.zillionchu.zillionchugenerator.generator.rest;

import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchugenerator.generator.entity.TableResultResponse;
import com.github.zillionchu.zillionchugenerator.generator.entity.XxlApiExcelSql;
import com.github.zillionchu.zillionchugenerator.generator.service.GeneratorService;
import com.github.zillionchu.zillionchugenerator.generator.utils.ExcelGenaSqlUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("/base/generatorsql")

public class ExcelGeraSqlController {

    @Autowired
    private GeneratorService generatorService;

    private static final String filePath="C:/Users/createTable/CreateSql.txt";

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String ,Object> uploadFile(@RequestParam("file") MultipartFile[] file, Integer type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Map<String ,Object> map = new HashMap<>();
        //遍历上传文档个数
        String s=null;
        String realPath=null;
        for(MultipartFile multipartFile:file){
            //判断excel是否是excel
            String originalFilename = multipartFile.getOriginalFilename();
            String fileEndwith = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
            if ( ".xls".equals(fileEndwith)){
                //上传excel输入流
                byte[] eexcelbytes = multipartFile.getBytes();
                FileInputStream fis = (FileInputStream)multipartFile.getInputStream();
                Workbook wb = new HSSFWorkbook(fis);
                //调用工具类生成sql文件
                String table = ExcelGenaSqlUtils.createTable("", wb, multipartFile.getName());

                XxlApiExcelSql xxlApiExcelSql = new XxlApiExcelSql();
                xxlApiExcelSql.setUploadFileContant(eexcelbytes); //excel文件输入流
                xxlApiExcelSql.setUploadFileName(originalFilename);//上传文件名称
                xxlApiExcelSql.setDownFileContant(table.getBytes());//生成sql文件类容
                xxlApiExcelSql.setDownFileName("out"+originalFilename);
                generatorService.addExcelSql(xxlApiExcelSql);

                s = ExcelGenaSqlUtils.excelGreateSql(table, filePath);

            }else{
                System.out.println("文件类型错误!");
                map.put("code",1);
                return map;
            }
        }
        map.put("realPath",filePath);
        map.put("s",s);
        map.put("code",0);
        return map;
    }
}
