package JavaCamp.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaCamp.northwind.business.abstracts.ProductService;
import JavaCamp.northwind.core.utilities.result.DataResult;
import JavaCamp.northwind.core.utilities.result.Result;
import JavaCamp.northwind.core.utilities.result.SuccessDataResult;
import JavaCamp.northwind.core.utilities.result.SuccessResult;
import JavaCamp.northwind.dataAccess.abstracts.ProductDao;
import JavaCamp.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data to List");
	}
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product Added");
	}
	
	
}
