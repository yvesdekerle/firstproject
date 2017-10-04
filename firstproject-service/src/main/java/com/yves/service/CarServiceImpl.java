package com.yves.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yves.dto.CarDto;
import com.yves.dto.mapper.CarMapper;
import com.yves.model.Car;
import com.yves.repository.CarRepository;
import com.yves.repository.specifications.CarSpecificationsFactory;;

@Service
public class CarServiceImpl implements CarService {

	// Acces aux donnees
	@Autowired // spring data
	private CarRepository carRepository;
	@Autowired // specifications
	private CarSpecificationsFactory carSpecs;
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Autowired
	private CarMapper carMapper;
	
	
	// spring data
	@Override
	@Transactional(readOnly = true)
	public List<CarDto> findAll() {
		return mapCarToCarDto(carRepository.findAll());
	}
	
	// spring data
	@Override
	@Transactional(readOnly = true)
	public CarDto findOne(Long carId) {
		return carMapper.asCarDto(carRepository.findOne(carId));
	}
	
	// specifications
	@Override
	@Transactional(readOnly = true)
	public List<CarDto> findBySearchTerm(String searchTerm) {
		return mapCarToCarDto(carRepository.findAll(carSpecs.titleOrDescriptionContainsIgnoreCase(searchTerm)));
	}

	// CriteriaQuery
	@Override
	@Transactional(readOnly = true)
	public List<CarDto> findAllCarsByCriteriaBuilder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Car> cq = builder.createQuery(Car.class);
		Root<Car> root = cq.from(Car.class);
		cq.select(root);
		return mapCarToCarDto(entityManager.createQuery(cq).getResultList());
	}
	
	// spring-data : retour d'un stream a la place d'une liste ou d'une page
	// ne fonctionne pas si il y a une relation avec une autre table dans l'entite
		// recupere bien l'autre table mais se coupe au bout d'une moment
		// Caused by: java.sql.SQLException: Streaming result set com.mysql.jdbc.RowDataDynamic@41497dd0 is still active. No statements may be issued when any streaming result sets are open and in use on a given connection. Ensure that you have called .close() on any active streaming result sets before attempting more queries.
	@Override
	@Transactional(readOnly = true)
	public void findAllStreamed(){
		try(Stream<Car> carStream = carRepository.streamAll()) {
			carStream.forEach(s -> System.out.println(s)
				);
		} 
	}
	
	// QueryName
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Car> findAllByQN(){
		return entityManager.createNamedQuery(Car.FIND_ALL_NQ).getResultList();
	}

	@Override
	public List<CarDto> findById(Long id) {
		return mapCarToCarDto(carRepository.findById(id));
	} 
	
	
//	public List<Car> findAllByCarAndDrivers(){
//		List<Car> cars = entityManager.createNamedQuery(Car.FIND_ALL_NQ).getResultList();
//		for (Car c : cars) {
//		    Hibernate.initialize(c.getDrivers());
//		}
//		return cars;
//	}
	
	
	private List<CarDto> mapCarToCarDto(final List<Car> cars){
		if(CollectionUtils.isNotEmpty(cars)){
			return cars.stream().map(car -> carMapper.asCarDto(car)).collect(Collectors.toList());
		}
		return null;
	}
}
