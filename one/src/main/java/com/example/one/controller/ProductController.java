package com.example.one.controller;

import com.example.one.model.Product;
import com.example.one.model.ResponseObject;
import com.example.one.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abc")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/getAll")
    ResponseEntity<?> getAllProduct(){
        List<Product> list=  repository.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Product> FoundProduct = repository.findById(id);
    return FoundProduct.isPresent()?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Query Product Successfully",FoundProduct)

            ):
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed","Cannot find product with id = "+id,"")

            );
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        List<Product> foundProduct = repository.findByproductName(newProduct.getProductName().trim());
        if(!foundProduct.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Insert Product failed","")
            );
    }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Product successfully",repository.save(newProduct))
        );
};
    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct,@PathVariable Long id){
        Product updateProduct=repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setYearr(newProduct.getYearr());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);

                }).orElseGet(()->{
                    newProduct.setId(id);
                    return repository.save(newProduct);

                        }
                );
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update product successfully",updateProduct)
        );

    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        Boolean product= repository.existsById(id);
        if(product=true){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed","Failed","")
        );
    }

}
