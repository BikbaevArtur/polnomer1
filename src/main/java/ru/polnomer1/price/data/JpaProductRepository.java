package ru.polnomer1.price.data;

import org.springframework.data.repository.CrudRepository;
import ru.polnomer1.price.model.Product;

public interface JpaProductRepository extends CrudRepository<Product,String> {
}
