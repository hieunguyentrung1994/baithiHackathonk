package controller;

import model.Catalog;
import service.CatalogService;

import java.util.List;

public class CatalogController {
	private CatalogService catalogService = new CatalogService();
	

	public List<Catalog> getAll() {
		return catalogService.getAll();
	}
	

	public void save(Catalog catalog) {
		catalogService.save(catalog);
	}
	

	public Catalog findById(Integer integer) {
		return catalogService.findById(integer);
	}
	

	public void delete(Integer integer) {
		catalogService.delete(integer);
	}
	

}
