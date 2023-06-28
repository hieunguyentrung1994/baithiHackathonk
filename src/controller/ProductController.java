package controller;

import model.Product;
import service.ProductService;

import java.util.List;

public class ProductController  {
	private ProductService productService = new ProductService();
	
	

	public List<Product> getAll() {
		return productService.getAll();
	}
	

	public void save(Product product) {
		productService.save(product);
	}
	

	public Product findById(String s) {
		return productService.findById(s);
	}
	

	public void delete(String s) {
		productService.delete(s);
	}
	

}
