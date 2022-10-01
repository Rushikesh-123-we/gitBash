package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Product;
import com.springboot.repository.ProductRepository;

@RestController
public class ProductRestController {


	@Autowired
	ProductRepository productrepository;
	
	
	//get All Data
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productrepository.findAll();
	}

	//get single product
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product geProduct(@PathVariable("id") int id) {
		return productrepository.findById(id).get();
	}
	
	//save products
		@RequestMapping(value = "/product" , method = RequestMethod.POST)
		public Product createProduct(@RequestBody Product product) {
			return productrepository.save(product);
		}
//Java wellcome
}
