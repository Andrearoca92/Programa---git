<%-- 
    Document   : recomendacionResultados.jsp
    Created on : 19/08/2025, 2:48:16 p. m.
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.recomendaproweb.model.Recomendacion"%>
<%@page import="com.mycompany.recomendaproweb.model.Producto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultados de la Recomendación</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; line-height: 1.6; }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            max-width: 800px;
            margin: 30px auto;
        }
        h1 { text-align: center; color: #007bff; margin-bottom: 20px; }
        h2 { color: #0056b3; margin-top: 30px; border-bottom: 2px solid #eee; padding-bottom: 10px; }
        ul { list-style: none; padding: 0; }
        li {
            background-color: #e9ecef;
            margin-bottom: 10px;
            padding: 15px;
            border-radius: 8px;
            border: 1px solid #dee2e6;
            display: flex;
            flex-direction: column;
        }
        li strong { color: #333; font-size: 1.1em; }
        li span { color: #666; font-size: 0.9em; margin-top: 5px; }
        .no-results {
            text-align: center;
            color: #dc3545;
            font-weight: bold;
            font-size: 1.2em;
            padding: 20px;
            border: 1px solid #dc3545;
            border-radius: 8px;
            background-color: #f8d7da;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .back-link:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Resultados de la Recomendación</h1>
        <%
            Recomendacion recomendacion = (Recomendacion) request.getAttribute("recomendacion");
            
            if (recomendacion != null) {
        %>
                <h2><%= recomendacion.getCriterioDeRecomendacion() %></h2>
        <%
                List<Producto> productosRecomendados = recomendacion.getProductos();
                
                if (productosRecomendados != null && !productosRecomendados.isEmpty()) {
        %>
                    <ul>
                        <%
                            for (Producto p : productosRecomendados) {
                        %>
                                <li>
                                    <strong><%= p.getNombre() %></strong>
                                    <% if (p.getTipoCabello() != null && !p.getTipoCabello().isEmpty()) { %>
                                        <span>Tipo de Cabello: <%= p.getTipoCabello() %></span>
                                    <% } %>
                                    <% if (p.getTipoPiel() != null && !p.getTipoPiel().isEmpty()) { %>
                                        <span>Tipo de Piel: <%= p.getTipoPiel() %></span>
                                    <% } %>
                                    <% if (p.getCategoria() != null && !p.getCategoria().isEmpty()) { %>
                                        <span>Categoría: <%= p.getCategoria() %></span>
                                    <% } %>
                                    <% if (p.getMarca() != null && !p.getMarca().isEmpty()) { %>
                                        <span>Marca: <%= p.getMarca() %></span>
                                    <% } %>
                                </li>
                        <%
                            }
                        %>
                    </ul>
        <%
                } else {
        %>
                    <p class="no-results">No se encontraron productos que coincidan con tu selección.</p>
        <%
                }
            } else {
        %>
                <p class="no-results">No se pudo obtener la recomendación. Por favor, inténtalo de nuevo.</p>
        <%
            }
        %>
        <a href="index.jsp" class="back-link">Volver al Inicio</a>
    </div>
</body>
</html>