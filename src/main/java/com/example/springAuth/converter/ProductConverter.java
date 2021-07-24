package com.example.springAuth.converter;

import com.example.springAuth.annotations.Converter;
import com.example.springAuth.controller.product.models.ProductRequestModel;
import com.example.springAuth.controller.product.models.ProductResponseModel;
import com.example.springAuth.facade.product.ProductDTO;

@Converter
public class ProductConverter {

    public ProductDTO productDataObjFromRequest(ProductRequestModel requestModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(requestModel.getProductName());
        return productDTO;
    }

    public ProductResponseModel responseFromDataObj(ProductDTO dto){
        ProductResponseModel responseModel = new ProductResponseModel();
        responseModel.setId(dto.getId());
        responseModel.setProductName(dto.getProductName());
        return responseModel;
    }
}
