package ru.polnomer1.price.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ru.polnomer1.price.data.JpaProductRepository;
import ru.polnomer1.price.model.Product;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final JpaProductRepository jpaProductRepository;


    public ProductController(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @GetMapping("/get")
    public Iterable<Product> getProduct(){
       return jpaProductRepository.findAll();
    }

    @GetMapping("/get{id}")
   public Optional<Product> getProductId(@PathVariable String id){
        return jpaProductRepository.findById(id);
    }

    @PostMapping("/post")
    public Product postProduct(@RequestBody Product product){
        return jpaProductRepository.save(product);
    }
    @PutMapping("/put{id}")
   public ResponseEntity<Product> putProduct(@PathVariable String id,
                                       @RequestBody Product product){
        return (jpaProductRepository.existsById(id)
        ? new ResponseEntity<>(jpaProductRepository.save(product), HttpStatus.OK)
                :new ResponseEntity<>(jpaProductRepository.save(product),HttpStatus.CREATED));
    }

    @DeleteMapping("/delete{id}")
   public void deleteProduct(@PathVariable String id){
        jpaProductRepository.deleteById(id);
    }


}
