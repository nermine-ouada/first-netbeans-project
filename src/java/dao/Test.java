/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.SQLException;

import Model.Product;

/**
 *
 * @author nermi
 */
public class Test {
    public static void main(String[]args){
        ProductDao pd=new ProductDao();
        Product p=new Product(1,"product 2",20,10);
        try{
            pd.updateProduct(p);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
