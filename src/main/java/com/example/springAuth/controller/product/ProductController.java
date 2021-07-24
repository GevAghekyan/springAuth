package com.example.springAuth.controller.product;

import com.example.springAuth.controller.product.models.ProductRequestModel;
import com.example.springAuth.controller.product.models.ProductResponseModel;
import com.example.springAuth.facade.product.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class ProductController {

    private final ProductFacade productFacade;

    @Autowired
    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponseModel> create(@RequestBody ProductRequestModel requestModel) {
        ProductResponseModel saved = productFacade.create(requestModel);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseModel> getById(@PathVariable Long id) {
        ProductResponseModel byId = productFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/products")
    public ResponseEntity<ArrayList<ProductResponseModel>> getAll() {
        ArrayList<ProductResponseModel> all = productFacade.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<ArrayList<ProductResponseModel>> getByName(@PathVariable String name) {
        ArrayList<ProductResponseModel> allByName = productFacade.findAllByName(name);
        return ResponseEntity.ok(allByName);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<ProductResponseModel> updateById(@RequestBody ProductRequestModel requestModel,@PathVariable Long id){
        ProductResponseModel updatedById = productFacade.updateById(requestModel, id);
        return ResponseEntity.ok(updatedById);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productFacade.deleteById(id);
    }
}
