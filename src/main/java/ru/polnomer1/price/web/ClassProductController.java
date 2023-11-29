package ru.polnomer1.price.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.polnomer1.price.data.JpaClassProductRepository;
import ru.polnomer1.price.model.ClassProduct;

import java.util.Optional;

@RequestMapping("/classproduct")
@RestController
public class ClassProductController {
    private final JpaClassProductRepository jpaClassProductRepository;

    public ClassProductController(JpaClassProductRepository jpaClassProductRepository) {
        this.jpaClassProductRepository = jpaClassProductRepository;
    }


    @GetMapping("/get")
    public Iterable<ClassProduct> getClassProduct(){
        return jpaClassProductRepository.findAll();
    }

    @GetMapping("/get{id}")
    public Optional<ClassProduct> getClassProductId(@PathVariable String id){
        return jpaClassProductRepository.findById(id);
    }

    @PostMapping("/post")
    public ClassProduct postClassProduct(@RequestBody ClassProduct classProduct){
        return jpaClassProductRepository.save(classProduct);
    }

    @PutMapping("/put{id}")
    public ResponseEntity<ClassProduct> putClassProduct(@PathVariable String id,
                                                @RequestBody  ClassProduct classProduct){
        return(jpaClassProductRepository.existsById(id)
        ? new ResponseEntity<>(jpaClassProductRepository.save(classProduct), HttpStatus.OK)
        : new ResponseEntity<>(jpaClassProductRepository.save(classProduct),HttpStatus.CREATED));
    }

    @DeleteMapping("/delete{id}")
    public void deleteClassProduct(@PathVariable String id){
        jpaClassProductRepository.deleteById(id);
    }
}
