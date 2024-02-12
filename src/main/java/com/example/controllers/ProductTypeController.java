package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.ProductType;
import com.example.services.IProductType;

@RestController
@RequestMapping("/api/productType")
@CrossOrigin("*")
public class ProductTypeController {

	@Autowired
	IProductType p;

	@GetMapping(value = "/getAll")
	public List<ProductType> showAllProducts() {
		return p.getAllProducts();
 
	}

	@DeleteMapping(value = "/delete/{pid}")
	public void deleteProduct(@PathVariable Integer pid) {
		p.delete(pid);
	}

	@PutMapping(value = "/update/{pid}")
	public void updateProduct(@RequestBody ProductType product, @PathVariable Integer pid) {
		System.out.println("inside updatepro of controller");
		p.update(product, pid);
	}

	@PostMapping(value = "/addPoduct")
	public void addpro(@RequestBody ProductType product) {
		System.out.println("addpro called");
		p.addProductType(product);
	}

	
	@GetMapping("/getByType/{type}")
	public Optional<ProductType> getByType(@PathVariable String type) {
        return p.getByType(type);
    }

}
