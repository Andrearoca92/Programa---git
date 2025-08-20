package com.mycompany.recomendaproweb.model;

import java.util.List;

public class Recomendacion {
    private String criterioDeRecomendacion;
    private List<Producto> productos;

    public Recomendacion(String criterioDeRecomendacion, List<Producto> productos) {
        this.criterioDeRecomendacion = criterioDeRecomendacion;
        this.productos = productos;
    }

    public String getCriterioDeRecomendacion() { return criterioDeRecomendacion; }
    public void setCriterioDeRecomendacion(String criterioDeRecomendacion) { this.criterioDeRecomendacion = criterioDeRecomendacion; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}