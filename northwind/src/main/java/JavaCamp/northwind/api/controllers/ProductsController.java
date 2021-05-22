package JavaCamp.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaCamp.northwind.business.abstracts.ProductService;
import JavaCamp.northwind.core.utilities.result.DataResult;
import JavaCamp.northwind.core.utilities.result.Result;
import JavaCamp.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products") // api istek karşılama url adresini belirtir
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService producutService) {
		super();
		this.productService = producutService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}
	
	@PostMapping
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
}


