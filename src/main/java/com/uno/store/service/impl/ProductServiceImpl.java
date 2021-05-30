package com.uno.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.store.commons.ResponseDto;
import com.uno.store.commons.Values;
import com.uno.store.model.Product;
import com.uno.store.repository.ProductRepository;
import com.uno.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
  
 
   @Autowired
   ProductRepository productRepository;


    @Override
    public ResponseDto getProduct(String codeProduct) {
        List<Product>productList=productRepository.getProduct(codeProduct);
        int status=Values.APP_CODE_OK;
        if(productList.size()==0){
        	status = Values.APP_CODE_NOT_RESOURCE_FOUND;
        }
        return new ResponseDto(status,productList);
    }

    @Override
    public ResponseDto saveProduct(Product product) {
        productRepository.addProduct(product);
        return  new ResponseDto(Values.APP_CODE_OK,product);
    }

	@Override
	public List<Product> getListProducts() {
		return  productRepository.getListMemory();
	}
}
