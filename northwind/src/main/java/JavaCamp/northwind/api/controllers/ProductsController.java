package JavaCamp.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaCamp.northwind.business.abstracts.ProductService;
import JavaCamp.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products") // api istek karşılama url adresini belirtir
public class ProductsController {
	
	private ProductService producutService;
	
	@Autowired
	public ProductsController(ProductService producutService) {
		super();
		this.producutService = producutService;
	}

	@GetMapping("/getall")
	public List<Product> getAll() {
		return this.producutService.getAll();
	}
}


