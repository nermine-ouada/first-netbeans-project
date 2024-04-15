<%-- 
    Document   : listProduct
    Created on : Apr 15, 2024, 11:22:47 AM
    Author     : nermi
--%>

<%@page import="dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page import="java.sql.SQLException"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" >

    </head>
    <body>

        <div class="container mt-5 p-6">
            <div style="text-align:center">
                <div class="row">
                    <div class="col-8">
                        <h3 class="d-inline-block">Product List</h3>
                    </div>
                    <div class="col-4">                    
                        <a href="addProduct.jsp" class="btn btn-info d-inline-block">Add new Product</a>
                    </div>
                </div>

                <table class="table">
                    <thead>
                        <tr  class="table-info">
                            <th>Id</th>
                            <th>Label</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ProductDao pd = new ProductDao();
                            List<Product> lp = null;
                            try {
                                lp = pd.selectAll();
                            } catch (SQLException e) {
                                System.out.println(e);
                            }

                            for (Product p : lp) {%>
                        <tr>
                            <td><%= p.getId()%></td>
                            <td><%= p.getLabel()%></td>
                            <td><%= p.getPrice()%></td>
                            <td><%= p.getQte()%></td>
                            <td>
                                <form action="DeleteProduct" method="post">
                                    <a href="updateProduct.jsp?id=<%= p.getId()%>" class="btn btn-info">Update</a>
                                    <input value="<%= p.getId()%>" name="id" hidden="true"/>  
                                    <button type="submit" class="btn btn-info">Delete</button>

                                </form>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
