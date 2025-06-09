/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author macbookprom1
 */
public class DBConnect {
    
//    Phương thức kết nối DB
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=java2_demo;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(url, "sa", "123456A@");
            
            return con;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
}
