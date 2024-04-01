<%-- 
    Document   : newjsp
    Created on : Mar 4, 2024, 12:47:18 PM
    Author     : nermi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" >

    </head>
    <body>
        <div class="container mt-5 p-6 w-50">
            <div style="text-align:center">
                <h3 style="color:#03C04A">Product successfully added!</h3>
                <%  
                    String label = request.getAttribute("label").toString();
                    String price = request.getAttribute("price").toString();
                    String qte = request.getAttribute("qte").toString();

                %>
                <span>Label : </span><%=label%><br>
                <span>Price : </span><%=price%><span>Dt</span><br>
                <span>Quantity : </span><%=qte%><br>

                <div class="text-center mt-2 ">
                    <a href="update.jsp" class="btn btn-info">
                        Update
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
