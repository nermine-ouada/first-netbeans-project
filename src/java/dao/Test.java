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

    public static void main(String[] args) {
        ProductDao pd = new ProductDao();
        try {
            pd.deleteProduct(15);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
