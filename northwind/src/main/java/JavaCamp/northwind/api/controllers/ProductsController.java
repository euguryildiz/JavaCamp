package JavaCamp.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaCamp.northwind.business.abstracts.ProductService;
import JavaCamp.northwind.core.utilities.result.DataResult;
import JavaCamp.northwind.core.utilities.result.Result;
import JavaCamp.northwind.entities.concretes.Product;
import JavaCamp.northwind.entities.dtos.ProductWithCategoryDto;

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
	
	@GetMapping("/getallByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getallDesc")
	public DataResult<List<Product>> getallDesc() {
		return this.productService.getAllSorted();
	}
	
	
	@PostMapping
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("getProductWithCategoryDetail")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetail()
	{
		return this.productService.getProductWithCategoryDetail();
	}
	
	
}


