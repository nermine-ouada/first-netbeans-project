package dao;

import Model.Product;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nermi
 */
public class ProductDao {

    public ProductDao() {
    }

    ConnMysql cm = new ConnMysql();

    private static final String INSERT_PRODUCT_SQL = "Insert into Product (Label,price,qte) values(?,?,?);";

    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try {
            Connection connection = cm.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getLabel());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQte());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static final String UPDATE_PRODUCT_SQL = "UPDATE Product SET Label = ?, price = ?, qte = ? WHERE id = ?;";

    public void updateProduct(Product product) throws SQLException {
        System.out.println(UPDATE_PRODUCT_SQL);
        try {
            Connection connection = cm.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1, product.getLabel());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQte());
            preparedStatement.setInt(4, product.getId()); 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
