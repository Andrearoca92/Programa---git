/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recomendaproweb.servlet;

import com.mycompany.recomendaproweb.dao.RecomendacionDAO;
import com.mycompany.recomendaproweb.model.Recomendacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recomendar")
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tipoCabello = request.getParameter("tipoCabello");
        String tipoPiel = request.getParameter("tipoPiel");
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");

        RecomendacionDAO recomendacionDAO = new RecomendacionDAO();
        Recomendacion recomendacion = recomendacionDAO.obtenerRecomendacionCompleta(tipoCabello, tipoPiel, categoria, marca);

        request.setAttribute("recomendacion", recomendacion);
        
        request.getRequestDispatcher("/WEB-INF/recomendacionResultados.jsp").forward(request, response);
    }
}