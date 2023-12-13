package ru.polnomer1.price.data;

import org.springframework.data.repository.CrudRepository;
import ru.polnomer1.price.model.OrderProduct;

public interface JpaOrderProduct extends CrudRepository<OrderProduct,String> {
}
