package com.uno.store.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.uno.store.model.Product;

@Component
public class ProductRepository {
	
	

    private List<Product> listMemory;

    public List<Product> getListMemory() {
        return listMemory;
    }

    public void setListMemory(List<Product> listMemory) {
        this.listMemory = listMemory;
    }

    private final static int NUMBER_OF_PRODUCT=100;

    public void initializeListProduct(){
    	listMemory = new ArrayList<>();
        int minCode = 100;
        int maxCode = 1000;
        int minUnit = 100;
        int maxUnit = 1000;
        double minPrice = 10;
        double maxPrice = 100;

        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            Product product= new Product();
            product.setCodeProduct(getRandomCode(minCode,maxCode)+"");
            product.setDescription(getRandomDescription());
            product.setSalePrice(getRandomPrice(minPrice,maxPrice));
            product.setUnit(getRandomCode(minUnit,maxUnit)+"");
            listMemory.add(product);
        }
    }
    public String getRandomDescription() {
        Random r = new java.util.Random ();
        return Long.toString (r.nextLong () & Long.MAX_VALUE, 36);
    }
    public double getRandomPrice(double min, double max) {
        return  ((Math.random() * (max - min)) + min);
    }
    public int getRandomCode(int minCode, int maxCode) {
        return ((int) (minCode + (Math.random() * (maxCode - minCode))));
    }

    public List<Product> getProduct(String codeProduct) {
        return listMemory.stream().filter(p->p.getCodeProduct().equals(codeProduct)).collect(Collectors.toList());
    }

    public void addProduct(Product product) {
        listMemory.add(product);
    }
    
    public void discountUnitProduct(String codeProduct) {
    	List<Product>productFound=getProduct(codeProduct);
    	if(productFound.size()>0) {
    		int unitNumber=Integer.parseInt(productFound.get(0).getUnit());    		
    		productFound.get(0).setUnit((unitNumber--)+"");
    	}
    }

}
