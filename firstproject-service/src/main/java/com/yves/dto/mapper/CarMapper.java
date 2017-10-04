package com.yves.dto.mapper;

import com.yves.dto.CarDto;
import com.yves.model.Car;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

//import fr.xebia.extras.selma.IoC;
//import fr.xebia.extras.selma.Mapper;

@Mapper(
	withIoC = IoC.SPRING, 
	withIoCServiceName="CarMapper",
	withIgnoreMissing = IgnoreMissing.ALL)
public interface CarMapper {

	CarDto asCarDto(Car in);
	
	Car asCar(CarDto in);
}
