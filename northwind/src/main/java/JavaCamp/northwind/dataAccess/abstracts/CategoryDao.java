package JavaCamp.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaCamp.northwind.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
