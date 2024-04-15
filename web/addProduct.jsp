<%-- 
    Document   : p1
    Created on : Feb 26, 2024, 12:14:10 PM
    Author     : nermi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" >

    </head>
    <body>
        <div class="container mt-5 p-6 w-50">
            <div>
                <h1>Add new Product!</h1>

                <form action="InsertProduct" class="mt-2" method="post">
                 
                    <input
                        type="text"
                        class="form-control"
                        id="label"
                        name="label"
                        placeholder="enter product label"
                        required
                        />
                    <br />
                    <input
                        type="number"
                        class="form-control"
                        id="price"
                        name="price"
                        placeholder="enter product price"
                        required
                        /><br />
                    <input
                        type="number"
                        class="form-control"
                        id="qte"
                        name="qte"
                        placeholder="enter product quantity"
                        required
                        />
                    <div class="text-center mt-2 ">
                        <button type="submit" class="btn btn-info">
                            Add                        </button>
                    </div>
                </form>
            </div>
    </body>
</html>
