package JavaCamp.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		return new SuccessDataResult<List<Product>>("Product List",this.productDao.findAll());
	}
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}
	@Override
	public DataResult<List<Product>> getAllSorted() {	
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>("Product List",this.productDao.findAll(sort));
	}
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product Added");
	}
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>("Data list",this.productDao.getByProductName(productName));
	}
	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>("Data list",this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId));
	}
	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>("Data list",this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId));
	}
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>("Data list",this.productDao.getByCategory_CategoryIdIn(categories));
	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>("Data list",this.productDao.getByProductNameContains(productName));
	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>("Data list",this.productDao.getByProductNameStartsWith(productName));
	}
	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>("Data list",this.productDao.getByNameAndCategory_CategoryId(productName, categoryId));
	}

	
	
}
