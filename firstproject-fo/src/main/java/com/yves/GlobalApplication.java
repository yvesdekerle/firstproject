package com.yves;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.yves.model.Car;
import com.yves.properties.CustomProperties;
import com.yves.properties.GlobalProperties;
import com.yves.repository.CarRepository;
import com.yves.repository.UserRepository;
import com.yves.service.CarServiceImpl;

@SpringBootApplication
@EnableJpaAuditing
public class GlobalApplication implements CommandLineRunner {


	
	
	@Autowired
	private UserRepository userRepository;
	
	// Properties
	@Autowired
	private CustomProperties prop;
	@Autowired
	private GlobalProperties appProp;
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Car c = new Car();
//		for(int i=0; i<20; i++){
//			c = new Car();
//			c.setPlate("myplzate" + LocalDateTime.now());
//			c.setType("A");
//			c.setMaxSpeed(10);
//			c.setHorsePower(77);
//			c.setFuelUsage(1.56);
//			c.setColor(new CarColor("rouge", "bleu"));
////			if(i==0) c.setUser(u);
////			else if(i==1) c.setUser(u2);
//			carRepository.save(c);
//		}
//		
//		c = new Car();
//		c.setPlate("firstcar" + LocalDateTime.now());
//		c.setType("A");
//		c.setMaxSpeed(99);
//		c.setHorsePower(12);
//		c.setFuelUsage(3.89);
//		c.setColor(new CarColor("rouge", "bleu"));
//		carRepository.save(c);
//		
//		Driver u = new Driver();
//		u.setName("Yves");
//		u.setCar(c);
//		userRepository.save(u);
//		
//		
//		c = new Car();
//		c.setPlate("secondcar" + LocalDateTime.now());
//		c.setType("A");
//		c.setMaxSpeed(99);
//		c.setHorsePower(12);
//		c.setFuelUsage(3.89);
//		c.setColor(new CarColor("rouge", "bleu"));
//		carRepository.save(c);
//		
//		Driver u2 = new Driver();
//		u2.setName("Audrey");
//		u2.setCar(c);
//		userRepository.save(u2);
		
		
//		
//		for(int i=0; i<3; i++){
//			c.setPlate("myplate" + LocalDateTime.now());
//			c.setType("Z");
//			carRepository.save(c);
//		}
		
//		List<Car> cars = carRepository.findAllByOrderByPlate(new PageRequest(0, 10));
//		System.out.println("Liste de " + cars.size() + "/10 voitures:");
//		cars.stream().forEach(System.out::println);
//		
//		List<String> carsTypes = carRepository.findAllUsedTypes();
//		System.out.println("Liste de " + carsTypes.size());
//		carsTypes.stream().forEach(System.out::println);
//		
//		List<CarDto> searchCars = carSearchServiceRepository.findBySearchTerm("Z");
//		System.out.println("Resultats pour searchCars nb:" + searchCars.size());
//		searchCars.stream().forEach(System.out::println);
		
		
//		System.out.println("####### AppProperties " + appProp);
//    	System.out.println("####### Properties" + prop);
//    	
//    	System.out.println("****** Car_.plate.getName()=" + Car_.plate.getName());
//    	System.out.println("****** Car_.maxSpeed.getName()=" + Car_.maxSpeed.getName());
		
//		carRepository.deleteAll();
		
//    	LocalDateTime start = LocalDateTime.now();
//    	List<CarDto> searchCars2 = carSearchServiceRepository.findAllCarsByCriteriaBuilder();
//		System.out.println("Resultats pour searchCars nb:" + searchCars2.size());
//		searchCars2.stream().forEach(System.out::println);
//		LocalDateTime end = LocalDateTime.now();
		
		
//		System.out.println("***********************");
//		LocalDateTime start2 = LocalDateTime.now();
//		carSearchServiceRepository.findAllStreamed();
//		LocalDateTime end2 = LocalDateTime.now();
		
		
//		System.out.println("Classic:" + Duration.between(end, start).getNano() + "ns");
//		System.out.println("Stream:" + Duration.between(end2, start2).getNano() + "ns");
		
		
//		System.out.println("***********************");
//		List<Car> cars = carRepository.findAll();
//		cars.stream().forEach(System.out::println);
//		System.out.println("***********************");
		
		System.out.println("####### AppProperties " + appProp);
    	System.out.println("####### Properties" + prop);
    	
    	
//		System.out.println("***********************");
//		List<Car> cars = carRepository.findById(2L);
//		cars.stream().forEach(System.out::println);
//		System.out.println("***********************");  
		
		
//		System.out.println("***********************");
//		List<Car> cars = carSearchServiceRepository.findAllByCarAndDrivers();
//		cars.stream().forEach(System.out::println);
//		System.out.println("***********************");  
		
	}
}
