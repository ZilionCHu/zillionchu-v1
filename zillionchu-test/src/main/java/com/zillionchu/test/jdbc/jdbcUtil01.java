package com.zillionchu.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-07-10 11:29
 * @Description:
 */
public class jdbcUtil01 {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String DB2 = "jdbc:db2://10.7.101.55:50000/foticdb5";

    //    private static final String u = "root";
//    private static final String p = "root";
    private static final String u = "db2inst1";
    private static final String p = "db2@Fotic55";


    public static String get(long var2, Connection conn, PreparedStatement psmt, ResultSet rs) {
        System.out.println("====  var2  is  :" + var2);
        String sql = "select PROCESSINSTID from  WFPROCESSINST  where parentProcID= ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, var2);
            rs = psmt.executeQuery();
            // String var1 = null;
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement psmt = null;
        //PreparedStatement psmts = null;
        ResultSet rs = null;
        //ResultSet rss = null;

        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            conn = DriverManager.getConnection(DB2, u, p);
            String sql = "select PROCESSINSTID from  WFPROCESSINST  where parentProcID= ?";
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, 745741);
            rs = psmt.executeQuery();
            //System.out.println(rs.getString(1));
            String var1 = null;
            while (rs.next()) {
                System.out.println(rs.getString(1));
                var1 = rs.getString(1);
            }
            System.out.println(var1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

