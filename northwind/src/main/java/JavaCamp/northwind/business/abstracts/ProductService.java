package JavaCamp.northwind.business.abstracts;

import java.util.List;

import JavaCamp.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
}
