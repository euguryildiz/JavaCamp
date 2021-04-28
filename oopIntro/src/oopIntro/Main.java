package oopIntro;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		Product product1 = new Product(1,"Lenova",15000,"Test", 10 );   // Referans oluşturma, intance

		
		Product product2 = new Product(); 
		product2.setId(2);
		product2.setName("MONSTER ABRA A5 V16.3.1");
		product2.setDetail("16 GB RAM");
		product2.setDiscount(10);
		product2.setUnitPrice(16000);
		
		
		Product product3 = new Product();  

		
		Product[] products = {product1,product2,product3};
		
		

		
		for (Product product : products) {
			System.out.println(product.getName()+" "+product.getUnitPrice());
			
		}
		
		System.out.println("---------------------------------------");
		
		
		Category category1 = new Category();
		category1.setId(1); 
		category1.setName("Bilgisayar");
		
		Category category2 = new Category();
		category2.setId(2); 
		category2.setName("Ram");
		
		
		Category[] categorys = {category1,category2};
		
		for (Category category : categorys) {
			System.out.println(category.getName());
		}

		
		
		ProductManager productManager = new ProductManager();
		productManager.addToCart(product1);
		
		productManager.addToCart(products);

		
	}

}
