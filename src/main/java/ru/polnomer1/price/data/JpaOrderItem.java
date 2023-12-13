package ru.polnomer1.price.data;

import org.springframework.data.repository.CrudRepository;
import ru.polnomer1.price.model.OrderItem;

public interface JpaOrderItem extends CrudRepository<OrderItem,String> {
}
