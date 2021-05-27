package JavaCamp.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
	
	@Id	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category") // // Tablo bağlantı tipini belli eder. bire çok bağlantı // Burada entity değilde bağlı entity içindeki private alan ile eşleştirme yapılır.
	private List<Product> products;
	
}
