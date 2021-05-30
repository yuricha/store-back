package com.uno.store.service;

import com.uno.store.commons.ResponseDto;
import com.uno.store.model.Product;

import java.util.List;

public interface ProductService {

	ResponseDto getProduct(String codeProduct);

    ResponseDto saveProduct(Product product);

	List<Product> getListProducts();
}
