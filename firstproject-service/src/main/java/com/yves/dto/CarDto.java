package com.yves.dto;

import javax.validation.constraints.Min;

public class CarDto {
	
    private String plate;
    private String type;
    private int horsePower;
    
    @Min(80)
    private int maxSpeed;
    private double fuelUsage;
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getFuelUsage() {
		return fuelUsage;
	}
	public void setFuelUsage(double fuelUsage) {
		this.fuelUsage = fuelUsage;
	}
	@Override
	public String toString() {
		return "CarDto [plate=" + plate + ", type=" + type + ", horsePower=" + horsePower + ", maxSpeed=" + maxSpeed
				+ ", fuelUsage=" + fuelUsage + "]";
	}
	
}
