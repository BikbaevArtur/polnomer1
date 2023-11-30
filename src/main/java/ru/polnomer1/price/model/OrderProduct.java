package ru.polnomer1.price.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Product product;
    private List<Product> orderProduct = new ArrayList<>();
    private List<OrderDetail> orderDetails = new ArrayList<>();


    public void addProduct(Product product){
        orderProduct.add(product);
    }
    public void addOrderList(Client client,List<Product> orderProduct){
        OrderDetail orderDetail = new OrderDetail(client,orderProduct);
        orderDetails.add(orderDetail);
    }



}
