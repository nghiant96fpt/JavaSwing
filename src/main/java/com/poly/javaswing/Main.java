/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.javaswing;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 *
 * @author macbookprom1
 */
public class Main {
    final String PRODUCT_NAME = "abc";
    
    public static void main(String[] args){
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);

        AddProduct2JFrame addProductFrame = new AddProduct2JFrame();
        addProductFrame.setVisible(true);
    }
}

// Khai báo hoặc tạo tên class hoặc 1 file .java hoa
// => Chữ đầu tiên của mỗi từ phải viết hoa

// Khai báo tên biến và tên phương thức 
// Nếu trường hợp có 1 từ => tất cả ký tự viết thường 
// Nếu có từ 2 từ trở lên => từ đầu tiên viết thường bất đầu từ từ thứ 2
// trở đi viết hoa chữ cái đầu tiên 

// Biến hằng số => là biến bắt buộc có giá trị và giá trị không thể thay đổi
// Khai báo biến hằng số => Tất cả các ký tự phải viết hoa
// Nếu có từ 2 từ trở lên thì các từ cách nhau bởi dấu _
