package JavaCamp.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaCamp.northwind.business.abstracts.ProductService;
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
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productDao.findAll();
	}

}
