package com.example.ms2_funcionaaa.Domain;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import java.util.List;

@Schema(name = "Compra", description = "Compra del cliente")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)

@Table(name = "compra")


public class Compra{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date fecha_compra;
    private Float monto_Total;
    private String metodo_de_pago;


    public Compra() {}

    public Compra(Long id, Date fecha_compra, Float monto_Total, String metodo_de_pago) {
        this.id = id;
        this.fecha_compra = fecha_compra;
        this.monto_Total = monto_Total;
        this.metodo_de_pago = metodo_de_pago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Float getMonto_Total() {
        return monto_Total;
    }

    public void setMonto_Total(Float monto_Total) {
        this.monto_Total = monto_Total;
    }

    public String getMetodo_de_pago() {
        return metodo_de_pago;
    }

    public void setMetodo_de_pago(String metodo_de_pago) {
        this.metodo_de_pago = metodo_de_pago;
    }

}