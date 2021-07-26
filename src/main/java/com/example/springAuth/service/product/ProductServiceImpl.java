package com.example.springAuth.service.product;

import com.example.springAuth.facade.product.ProductDTO;
import com.example.springAuth.persistence.entities.Product;
import com.example.springAuth.persistence.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product product = buildProductFromDto(dto);
        Product saved = productRepo.save(product);
        return buildDtoFromProduct(saved);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product byId = productRepo.getById(id);
        return buildDtoFromProduct(byId);
    }

    @Override
    public ArrayList<ProductDTO> findAll() {
        List<Product> all = productRepo.findAll();
        List<ProductDTO> dataObjects = all.stream()
                .map(each -> buildDtoFromProduct(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductDTO>) dataObjects;
    }

    @Override
    public ArrayList<ProductDTO> findAllByName(String name) {
        ArrayList<Product> all = productRepo.findAllByProductName(name);
        List<ProductDTO> dataObjects = all.stream()
                .map(each -> buildDtoFromProduct(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductDTO>) dataObjects;
    }

    @Override
    public ProductDTO updateById(ProductDTO dto) {
        Product byId = productRepo.getById(dto.getId());
        byId.setProductName(dto.getProductName());
        Product saved = productRepo.save(byId);
        return buildDtoFromProduct(saved);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    private Product buildProductFromDto(ProductDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setId(dto.getId());
        return product;
    }

    private ProductDTO buildDtoFromProduct(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        return dto;
    }
}
