package com.example.camisasapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "camisas")
public class Camisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String talla;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public Camisa() {
    }

    public Camisa(String modelo, String talla, Double precio, Marca marca) {
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
