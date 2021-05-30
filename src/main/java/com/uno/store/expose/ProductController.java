package com.uno.store.expose;

import com.uno.store.commons.HttpStatusUtil;
import com.uno.store.commons.ResponseDto;
import com.uno.store.commons.Values;
import com.uno.store.model.Product;
import com.uno.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;
    
    @GetMapping("/product")
    public ResponseEntity<String> getProduct(){

        return new HttpStatusUtil().getHttpStatusByResponse(new ResponseDto(Values.APP_CODE_OK, productService.getListProducts()));
    }
    
    @GetMapping("/product/{codeProduct}")
    public ResponseEntity<String> getProduct(@PathVariable("codeProduct")  String codeProduct){
    	
        return new HttpStatusUtil().getHttpStatusByResponse(productService.getProduct(codeProduct));
    }

    @PostMapping("/product")
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        return new HttpStatusUtil().getHttpStatusByResponse(productService.saveProduct(product));
    }
}
