package com.example.camisasapi.dto;

public class CamisaDto {
    private Long id;
    private String modelo;
    private String talla;
    private Double precio;
    private MarcaDto marca;

    public CamisaDto() {
    }

    public CamisaDto(Long id, String modelo, String talla, Double precio, MarcaDto marca) {
        this.id = id;
        this.modelo = modelo;
        this.talla = talla;
        this.precio = precio;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public MarcaDto getMarca() {
        return marca;
    }

    public void setMarca(MarcaDto marca) {
        this.marca = marca;
    }
}
