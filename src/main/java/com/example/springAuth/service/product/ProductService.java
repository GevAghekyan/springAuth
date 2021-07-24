package com.example.springAuth.service.product;

import com.example.springAuth.facade.product.ProductDTO;

import java.util.ArrayList;

public interface ProductService {

    ProductDTO create(ProductDTO dto);

    ProductDTO getById(Long id);

    ArrayList<ProductDTO> findAll();

    ArrayList<ProductDTO> findAllByName(String name);

    ProductDTO updateById(ProductDTO dto);

    void deleteById(Long id);

}
