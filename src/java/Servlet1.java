/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Model.Product;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nermi
 */
public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        // Check if the action is to insert or update
        if ("insert".equals(action)) {
            // Insertion logic
            String label = request.getParameter("label");
            String price = request.getParameter("price");
            String qte = request.getParameter("qte");
            Product p = new Product(label, Integer.parseInt(price), Integer.parseInt(qte));
            request.setAttribute("label", label);
            request.setAttribute("price", price);
            request.setAttribute("qte", qte);
            ProductDao pd = new ProductDao();
            try {
                pd.insertProduct(p);
            } catch (SQLException e) {
                System.out.println(e);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
            rd.forward(request, response);
        }else if ("update".equals(action)) {
            String productId = request.getParameter("productId");
            String label = request.getParameter("label");
            String price = request.getParameter("price");
            String qte = request.getParameter("qte");
            Product updatedProduct = new Product( Integer.parseInt(productId), label, Integer.parseInt(price), Integer.parseInt(qte));

            ProductDao pd = new ProductDao();
            try {
                pd.updateProduct(updatedProduct);
                response.sendRedirect("success.jsp"); // Redirect to a success page after updating
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
