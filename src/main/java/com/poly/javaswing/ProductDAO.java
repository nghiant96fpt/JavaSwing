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
public class ProductDAO {
    public static ArrayList<Product> findAll(){
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT p.id, p.name, p.price, p.quantity,"
                + " p.discount_price, c.id AS cat_id, c.name AS cat_name"
                + " FROM products p JOIN categories c ON p.cat_id=c.id";
        
            PreparedStatement preStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setDiscount(resultSet.getInt("discount_price"));
                
                Category category = new Category();
                category.setId(resultSet.getInt("cat_id"));
                category.setName(resultSet.getString("cat_name"));
                
                product.setCategory(category);
                products.add(product);
            }
            
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }
    
//    Tìm thông tin của 1 sản phẩm theo id của sản phẩm 
    
    public static Product findById(int id){
        
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT p.id, p.name, p.price, p.quantity,"
                + " p.discount_price, c.id AS cat_id, c.name AS cat_name"
                + " FROM products p JOIN categories c ON p.cat_id=c.id WHERE id=?"; // AND name=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setInt(1, id);
//            preStatement.setString(2, "'abc'");
            ResultSet resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setDiscount(resultSet.getInt("discount_price"));
                
                Category category = new Category();
                category.setId(resultSet.getInt("cat_id"));
                category.setId(resultSet.getInt("cat_name"));
                
                product.setCategory(category);
                
                return product;
            }
            
           
            conn.close();
        }catch(Exception e){
            
        }
        
//      Nếu không tim được và code chạy đến đây thì trả về null
//      => Không có sản phẩm nào được tìm thấy thông tin tin 
        return null;
    }
    
//  Xây dựng 1 hàm insert (Thêm sản phẩm vào db)
    public static boolean insert(Product product){
        try{
            Connection conn = DBConnect.getConnection();
            
//          Lệnh insert 
            String sql = "INSERT INTO products(name, price, quantity, discount_price, cat_id) "
                    + "VALUES(?, ?, ?, ?, ?)";
            
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, product.getName());
            preStatement.setInt(2, product.getPrice());
            preStatement.setInt(3, product.getQuantity());
            preStatement.setInt(4, product.getDiscount());
            preStatement.setInt(5, product.getCategory().getId());
            
            preStatement.execute();
            conn.close();
            
//          Thêm thành công 
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
//      Có lỗi xảy ra 
        return false;
    }
    
    public static boolean update(Product product){
        try{
            Connection conn = DBConnect.getConnection();
//          Lệnh insert 
            String sql = "UPDATE products SET name=?, price=?, quantity=?, discount_price=?, cat_id=? WHERE id=?";
            
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, product.getName());
            preStatement.setInt(2, product.getPrice());
            preStatement.setInt(3, product.getQuantity());
            preStatement.setInt(4, product.getDiscount());
            preStatement.setInt(5, product.getCategory().getId());
            preStatement.setInt(6, product.getId());
            
            preStatement.execute();
            conn.close();
            
//          Thêm thành công 
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
//      Có lỗi xảy ra 
        return false;
    }
    
    public static boolean delete(int id){
        try{
            Connection conn = DBConnect.getConnection();
//          Lệnh insert 
            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setInt(1, id);
            preStatement.execute();
            conn.close();
            
//          Thêm thành công 
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
//      Có lỗi xảy ra 
        return false;
    }
}
