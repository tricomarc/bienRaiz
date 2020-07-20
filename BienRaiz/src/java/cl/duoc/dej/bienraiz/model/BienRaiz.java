/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.model;

/**
 *
 * @author Raniela
 */
public class BienRaiz {
    
    private int id;
    private String titulo;
    private String descripcion;
    private String direccion;
    private Comuna id_comuna;
    private TipoPropiedad tipo_propiedad;
    private int metros_cuadrados;
    private int cantidad_dormitorios;
    private int cantidad_banios;
    private String otros;
    private float coordenada_latitud;
    private float coordenada_longitud;

    public BienRaiz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Comuna getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(Comuna id_comuna) {
        this.id_comuna = id_comuna;
    }

    public TipoPropiedad getTipo_propiedad() {
        return tipo_propiedad;
    }

    public void setTipo_propiedad(TipoPropiedad tipo_propiedad) {
        this.tipo_propiedad = tipo_propiedad;
    }

    public int getMetros_cuadrados() {
        return metros_cuadrados;
    }

    public void setMetros_cuadrados(int metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    public int getCantidad_dormitorios() {
        return cantidad_dormitorios;
    }

    public void setCantidad_dormitorios(int cantidad_dormitorios) {
        this.cantidad_dormitorios = cantidad_dormitorios;
    }

    public int getCantidad_banios() {
        return cantidad_banios;
    }

    public void setCantidad_banios(int cantidad_banios) {
        this.cantidad_banios = cantidad_banios;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public float getCoordenada_latitud() {
        return coordenada_latitud;
    }

    public void setCoordenada_latitud(float coordenada_latitud) {
        this.coordenada_latitud = coordenada_latitud;
    }

    public float getCoordenada_longitud() {
        return coordenada_longitud;
    }

    public void setCoordenada_longitud(float coordenada_longitud) {
        this.coordenada_longitud = coordenada_longitud;
    }
    
    // Hash code y Equals agregarlos
    
}
