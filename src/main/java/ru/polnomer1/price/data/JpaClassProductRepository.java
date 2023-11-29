package ru.polnomer1.price.data;

import org.springframework.data.repository.CrudRepository;
import ru.polnomer1.price.model.ClassProduct;

public interface JpaClassProductRepository extends CrudRepository<ClassProduct,String> {
}
