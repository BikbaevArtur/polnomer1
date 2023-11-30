package ru.polnomer1.price.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetail {
    private Client client;
    private final LocalDate localDate = LocalDate.now();
    private List<Product> productList;


}
