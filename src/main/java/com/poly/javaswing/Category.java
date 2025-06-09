/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.javaswing;

/**
 *
 * @author macbookprom1
 */
public class Category {
    private int id;
    private String name;
    
//    private List<Product> products;

//    Hàm xây dựng không tham số
    public Category() {
    }

//    Hàm xây dựng đầy đủ tham số
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
//  Phương thức 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
