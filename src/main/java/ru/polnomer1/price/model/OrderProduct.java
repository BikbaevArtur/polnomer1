package ru.polnomer1.price.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name="order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @OneToMany(mappedBy = "orderProduct",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public OrderProduct(Client client, Date orderDate, List<OrderItem> orderItems) {
        this.client = client;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }
}
