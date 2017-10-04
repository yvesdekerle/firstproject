package com.yves.service;

import java.util.List;

import com.yves.dto.CarDto;
import com.yves.model.Car;

public interface CarService {
	
	List<CarDto> findAll();
	CarDto findOne(Long carId);
	List<CarDto> findBySearchTerm(String searchTerm);
	List<CarDto> findAllCarsByCriteriaBuilder();
	void findAllStreamed();
	List<Car> findAllByQN();
	List<CarDto> findById(Long id);
	
//	List<Car> findAllByCarAndDrivers();
}
