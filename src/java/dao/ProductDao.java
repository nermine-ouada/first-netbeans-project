package dao;

import Model.Product;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nermi
 */
import java.util.ArrayList;
import java.util.List;

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
    private static final String SELECT_ALL_PRODUCTS = "SELECT * from PRODUCT";

    public List selectAll() throws SQLException {
        System.out.println(SELECT_ALL_PRODUCTS);
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = cm.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String label = res.getString("label");
                int price = res.getInt("price");
                int qte = res.getInt("qte");
                products.add(new Product(id, label, price, qte));
            }
            System.out.println(products.size());
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }
    private static final String SELECT_PRODUCT = "SELECT id,label,price,qte from PRODUCT where id=?";

    public Product selectProduct(int id) throws SQLException {
        System.out.println(SELECT_PRODUCT);
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = cm.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
            preparedStatement.setString(1, Integer.toString(id));
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int id1 = res.getInt("id");
                String label = res.getString("label");
                int price = res.getInt("price");
                int qte = res.getInt("qte");
                products.add(new Product(id1, label, price, qte));
            }
            System.out.println(products.size());
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products.getFirst();

    }
    private static final String DELETE_PRODUCT = "DELETE from PRODUCT where id=?";

    public void deleteProduct(int id) throws SQLException {
        System.out.println(DELETE_PRODUCT);
        try {
            Connection connection = cm.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setString(1, Integer.toString(id));
            preparedStatement.executeUpdate();

            System.out.println("product deleted");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
