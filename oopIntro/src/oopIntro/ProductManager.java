package oopIntro;

public class ProductManager {
	
	public void addToCart(Product product) {
		System.out.println("Sepete Eklendi "+product.getName());
	}
	
	public void addToCart(Product[] products)
	{
		for (Product product : products) {
			this.addToCart(product);
		}
	}
	
}
