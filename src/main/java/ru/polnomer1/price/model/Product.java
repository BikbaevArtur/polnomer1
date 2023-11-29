package ru.polnomer1.price.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassProduct classProduct;
    private String name;
    private int quantity;
    @Column(precision = 10,scale = 2)
    private BigDecimal purchasePrice;
    @Column(precision = 10,scale = 2)
    private BigDecimal dealerPrice;

}
