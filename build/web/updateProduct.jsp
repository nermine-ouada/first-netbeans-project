<%-- 
    Document   : update
    Created on : Apr 1, 2024, 3:40:14 PM
    Author     : nermi
--%>

<%@page import="dao.ProductDao"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update PAge</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" >

    </head>
    <body>
        <%

            // Product p = (Product)request.getAttribute("p");
            String id = request.getParameter("id");
            ProductDao pd = new ProductDao();
            Product p =null;
            try {
                p= pd.selectProduct(Integer.parseInt(id));
 
            } catch (SQLException e) {
                System.out.println(e);
            }

        %>
        <div class="container mt-5 p-6 w-50">
            <div>
                <h1>Update Product!</h1>

                <form action="UpdateProduct" class="mt-2" method="post">
                    <input type="hidden" name="action" value="update"> 
                    <input
                        type="text"
                        class="form-control"
                        id="id1"
                        name="id1"
                        placeholder="enter product id"
                        disabled
                        value="<%=p.getId()%>"
                        />
                    <input type="hidden"   id="id"
                        name="id"
                        value="<%=p.getId()%>">
                    <br />
                    <input
                        type="text"
                        class="form-control"
                        id="label"
                        name="label"
                        placeholder="enter product label"
                        required
                        value="<%=p.getLabel()%>"

                        />
                    <br />
                    <input
                        type="number"
                        class="form-control"
                        id="price"
                        name="price"
                        placeholder="enter product price"
                        required
                        value="<%=p.getPrice()%>"

                        /><br />
                    <input
                        type="number"
                        class="form-control"
                        id="qte"
                        name="qte"
                        placeholder="enter product quantity"
                        required
                        value="<%=p.getQte()%>"

                        />
                    <div class="text-center mt-2 ">
                        <button type="submit" class="btn btn-info">
                            Update                        </button>
                    </div>
                </form>
            </div>
    </body>
</html>
