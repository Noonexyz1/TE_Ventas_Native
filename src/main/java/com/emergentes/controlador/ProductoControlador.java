
package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Producto prod = new Producto();
            int id;
            ProductoDAO dao = new ProductoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("producto", prod);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    prod = dao.getById(id);
                    request.setAttribute("producto", prod);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProductoControlador");
                    break;

                case "view":
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;

                default:
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error doGET()" + e.getMessage());
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ProductoDAO dao = new ProductoDAOimpl();

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            float precio = Float.parseFloat(request.getParameter("precio"));

            Producto prod = new Producto();
            
            prod.setId(id);
            prod.setNombre(nombre);
            prod.setDescripcion(descripcion);
            prod.setPrecio(precio);

            if (id == 0) {
                dao.insert(prod);

            } else {
                dao.update(prod);
            }

        } catch (Exception e) {
            System.out.println("ERROR AL GUARDAR datos... doPost()" + e.getMessage());
        }

        response.sendRedirect("ProductoControlador");
    }

  

}
