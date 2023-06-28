package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product, String> {
	
	private List<Product> products = new ArrayList<>();
	
	@Override
	public List<Product> getAll() {
		return products;
	}
	
	@Override
	public void save(Product product) {
		if (findById(product.getProductId()) == null) {
			products.add(product);
		} else {
			products.set(products.indexOf(findById(product.getProductId())), product);
		}
	}
	
	@Override
	public Product findById(String s) {
		for (Product p : products) {
			if (p.getProductId().equals(s)) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public void delete(String s) {

	}


}
