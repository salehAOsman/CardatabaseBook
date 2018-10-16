package com.packt.cardatabase.domain;

import java.util.List;//we change down the class to be inteface extends from CrudRepository as it is down our inteface will extends our Car class and type of id that come from SQL
import java.util.Optional; //import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
//import org.hibernate.annotations.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> { //it is extend more than this normal CrudRepository
//public interface CarRepository extends CrudRepository<Car, Long> {// Generic type
//public interface CarRepository extends JpaRepository<Car, Long> {
	long count();

	Iterable<Car> findAll(Sort sort);// by CrudRepository
	// List<Car> findAll();//by JpaRepository

	Optional<Car> findById(ID Id);
	void delete(Car entity);
	void deleteAll();
	<S extends Car> S save(S car);// in the book there is an error missing S as return type
	// to define own queries in the spring Data repositories, start with prefix
	// findBy--> and add name of class fields as brand but camelCase the irt is
	// findByBrand as name of method  ظ
	// Fetch cars by brand
	
	@Query("select c from Car c where c.brand = ?1")//
	List<Car> findByBrand(String brand);
	
	// Fetch cars by year
	@Query("select d from Car d where d.year = ?1")
	List<Car> findByYear(int year);
	
	// Fetch cars by color
	@Query("select d from Car d where d.color = ?1")
	List<Car> findByColor(String color);
		
	// Fetch cars by findByBrandEndsWith
	@Query("select m from Car m where m.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	
}
//with big data we need sorting and paging data by Extends this interface from PagingAndSortingRepository<Car,Long>

