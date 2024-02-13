package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.entities.Product;

public interface IProductService {
	
	public void addProduct(Product product);

	public List<Product> getAllProducts();
	
	public Product getProduct(int id) ;

	public Optional<Product> deleteById(int id);

	//public void updateById(int id, Product obj);
	
	//public void updateById(ProductMaster product,long id);
	
	List<Product> getByType(int id);
	
	List<Product> getByLanguage(int id);
	
	List<Product> getByGenre(int id);

}
