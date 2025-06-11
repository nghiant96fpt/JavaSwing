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
                category.setId(resultSet.getInt("cat_name"));
                
                product.setCategory(category);
                products.add(product);
            }
            
            conn.close();
        }catch(Exception e){
            
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
}
