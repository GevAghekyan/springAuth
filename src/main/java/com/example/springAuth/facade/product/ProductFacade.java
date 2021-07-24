package com.example.springAuth.facade.product;

import com.example.springAuth.annotations.Facade;
import com.example.springAuth.controller.product.models.ProductRequestModel;
import com.example.springAuth.controller.product.models.ProductResponseModel;
import com.example.springAuth.converter.ProductConverter;
import com.example.springAuth.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class ProductFacade {

    private final ProductService productService;
    private final ProductConverter productConverter;

    @Autowired
    public ProductFacade(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    public ProductResponseModel create(ProductRequestModel requestModel) {
        ProductDTO dto = productConverter.productDataObjFromRequest(requestModel);
        ProductDTO dataObject = productService.create(dto);
        return productConverter.responseFromDataObj(dataObject);
    }

    public ProductResponseModel getById(Long id) {
        ProductDTO byId = productService.getById(id);
        return productConverter.responseFromDataObj(byId);
    }

    public ArrayList<ProductResponseModel> findAll() {
        ArrayList<ProductDTO> all = productService.findAll();
        List<ProductResponseModel> responseModels = all.stream()
                .map(each -> productConverter.responseFromDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductResponseModel>) responseModels;
    }

    public ArrayList<ProductResponseModel> findAllByName(String name) {
        ArrayList<ProductDTO> all = productService.findAllByName(name);
        List<ProductResponseModel> responseModels = all.stream()
                .map(each -> productConverter.responseFromDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductResponseModel>) responseModels;
    }

    public ProductResponseModel updateById(ProductRequestModel requestModel, Long id) {
        ProductDTO dto = productConverter.productDataObjFromRequest(requestModel);
        dto.setId(id);
        ProductDTO dataObject = productService.updateById(dto);
        return productConverter.responseFromDataObj(dataObject);
    }

    public void deleteById(Long id) {
        productService.deleteById(id);
    }
}
