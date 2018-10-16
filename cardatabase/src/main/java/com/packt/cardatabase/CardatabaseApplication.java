package com.packt.cardatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

//cardatabaseApplication
@SpringBootApplication
public class CardatabaseApplication {
	// 1- we add this interface as field here to fetch DB by CrudRepository class
	// that has many method
	@Autowired // to enable dependency to injection
	private CarRepository repository; // we add logger as obj_ by Logger class to fetch spring boot by 7 deference
										// ways
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		System.out.println("Besm Ellah");
		SpringApplication.run(CardatabaseApplication.class, args);
		
		logger.info("HELLO SALEH SPRING BOOT we commited to GitHub");
	}

	// we add info_ to database by method here
	@Bean //
	CommandLineRunner runner() {
		Car car1 = new Car("brand1", "model1", "color1", "regNam1", 2015, 200000);
		Car car2 = new Car("brand1", "model2", "color2", "regNam2", 2016, 250000);
		Car car3 = new Car("brand3", "model3", "color3", "regNam3", 2017, 300000);
		Car car4 = new Car("brand4", "model4", "color7", "regNam4", 2018, 350000);
		Car car5 = new Car("brand5", "model5", "color2", "regNam5", 2015, 200000);
		Car car6 = new Car("brand6", "model6", "color3", "regNam6", 2016, 250000);
		Car car7 = new Car("brand7", "model7", "color7", "regNam7", 2017, 300000);
		Car car8 = new Car("brand8", "model8", "color3", "regNam8", 2018, 350000);

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
		cars.add(car8);

		return x -> {
			repository.saveAll(cars);

			int count = 1;
			List<Car> myCarBrand = repository.findByBrand("brand1");
			for (Car car : myCarBrand) {
				System.out.println(count + " - Find by brand: " + car);
				count++;
			}
			count = 1;
			List<Car> myCarYear = repository.findByYear(2015);
			for (Car car : myCarYear) {
				System.out.println(count + " - Find by year: " + car);
				count++;
			}
			count = 1;
			List<Car> myCarColor = repository.findByColor("color7");
			for (Car car : myCarColor) {
				System.out.println(count + " - Find by color: " + car);
				count++;
			}
			count = 1;
			List<Car> myCarB = repository.findByBrandEndsWith("brand");
			for (Car car : myCarB) {
				System.out.println(count + " - Find by for like brand: " + car);
				count++;
			}
			String sortColumeY = "year";
			String sortColumeB = "brand";
			String sortColumeM = "model";
			Sort sort = new Sort(Direction.ASC, sortColumeY, sortColumeB);
			Sort sort1 = new Sort(Direction.ASC, sortColumeM);
			
			Iterable<Car> findAll = repository.findAll(sort);
			for (Car car : findAll) {
				System.out.println(count + " - Find all sort Desc y -> b: " + car);
				count++;
			}
		};
	};
}
