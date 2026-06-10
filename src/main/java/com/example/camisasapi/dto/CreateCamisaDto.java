package com.example.camisasapi.dto;

public class CreateCamisaDto {
    private String modelo;
    private String talla;
    private Double precio;
    private Long marcaId;

    public CreateCamisaDto() {
    }

    public CreateCamisaDto(String modelo, String talla, Double precio, Long marcaId) {
        this.modelo = modelo;
        this.talla = talla;
        this.precio = precio;
        this.marcaId = marcaId;
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

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }
}
