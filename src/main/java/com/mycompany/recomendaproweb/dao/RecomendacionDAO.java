/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recomendaproweb.dao;

import com.mycompany.recomendaproweb.model.Producto;
import com.mycompany.recomendaproweb.model.Recomendacion;
import com.mycompany.recomendaproweb.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecomendacionDAO {
    public Recomendacion obtenerRecomendacionCompleta(String tipoCabello, String tipoPiel, String categoria, String marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Recomendacion recomendacion = null;
        List<Producto> productos = new ArrayList<>();

        String criterioDeRecomendacion = "Tu selección: " + tipoCabello + ", " + tipoPiel + ", " + categoria;
        if (marca != null && !marca.trim().isEmpty()) {
            criterioDeRecomendacion += ", Marca " + marca;
        }

        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM productos WHERE tipoCabello = ? AND tipoPiel = ? AND categoria = ?";

            if (marca != null && !marca.trim().isEmpty()) {
                sql += " AND marca = ?";
            }

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoCabello);
            stmt.setString(2, tipoPiel);
            stmt.setString(3, categoria);

            if (marca != null && !marca.trim().isEmpty()) {
                stmt.setString(4, marca);
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTipoCabello(rs.getString("tipoCabello"));
                producto.setTipoPiel(rs.getString("tipoPiel"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setMarca(rs.getString("marca"));
                productos.add(producto);
            }

            recomendacion = new Recomendacion(criterioDeRecomendacion, productos);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return recomendacion;
    }
}