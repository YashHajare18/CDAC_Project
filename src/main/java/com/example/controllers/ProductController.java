package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.ProductDto;
import com.example.entities.Product;
import com.example.services.IProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
	@Autowired
    private IProductService proService;
	
	@GetMapping(value = "/getAll")
	 public List<Product> showProducts1()
	 {
		System.out.println("in showProducts1 method");
		  return proService.getAllProducts(); 
		
	 }
	
	@GetMapping(value = "productsById/{pid}")
	 public Product getPro(@PathVariable int pid)
	 {
		
		Product p=proService.getProduct(pid);
		return p;
	 }
	@DeleteMapping(value = "api/products/{pid}")
	 public void removepro(@PathVariable int pid)
	 {
		proService.deleteById(pid);
		
	 }

	@GetMapping("/getByType/{id}")
	public List<ProductDto> getByType(@PathVariable int id) {
		System.out.println("bytype");
		List<Product> list = proService.getByType(id);
		List<ProductDto> sendList = new ArrayList<>();
		for (Product obj : list) {
			ProductDto newObje = new ProductDto();
			newObje.setId(obj.getProductId());
			newObje.setLibrary(obj.isLibrary());
			newObje.setMinRentDays(obj.getMinRentDays());
			newObje.setPrice(obj.getBasePrice());
			newObje.setProductName(obj.getProductName());
			newObje.setRentable(obj.isRentable());
			newObje.setRentPerDay(obj.getRentPerDay());
			System.out.println("Is rentable "+obj.isRentable());
			sendList.add(newObje);
			
		}
		System.out.println(list);
		return sendList;
        	
	}
	
	@PostMapping(value = "/add")
	 public void addpro(@RequestBody Product product)
	 {
		System.out.println("addpro called");
		proService.addProduct(product);
	 }
	

}
