package ru.polnomer1.price.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="class_product")
public class ClassProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public ClassProduct(String name) {
        this.name = name;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "classProduct")
    private List<Product> products;

    public ClassProduct() {
    }
}
