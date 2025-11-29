package com.example.catalogservice.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    @JsonProperty("identificador del producto")
    private Long id;
    
    @Column(name = "name", nullable = false, length = 100)
    @JsonProperty("nombre del producto")
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    @JsonProperty("precio del producto")
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    @JsonProperty("stock del producto")
    private Integer stock;

    @Column(name = "status", nullable = false)
    @JsonProperty("estado del producto")
    private Integer status;

    @Column(name = "photo", nullable = false, length = 255)
    @JsonProperty("foto del producto")
    private String photo;

    //Relaciones
}