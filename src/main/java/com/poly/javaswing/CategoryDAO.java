/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.javaswing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author macbookprom1
 */
public class CategoryDAO {
    
    public static ArrayList<Category> findAll(){
        ArrayList<Category> categories = new ArrayList<Category>();

        try{
//          Kết nối db 
            Connection conn = DBConnect.getConnection();

//          Tạo lệnh SQL lấy danh sách danh mục trong db 
            String sql = "SELECT * FROM categories";
//          Thực thi lệnh SQL 
            PreparedStatement preStatement = conn.prepareStatement(sql);
//          Dữ liệu nhận được sau khi thực thi lệnh sql 
            ResultSet resultSet = preStatement.executeQuery();
//          resultSet => Trả về 1 cái list
//          while để duyệt mảng 
//          Điều kiện để dừng white => resultSet.next() == false
//          resultSet.next() == false => Không có item tiếp theo để lấy giá trị 
            while(resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                
                categories.add(category);
            }
            
//          Ngắt kết nối DB 
            conn.close();
        }catch(Exception e){
            
        }
        return categories;
    }
}
