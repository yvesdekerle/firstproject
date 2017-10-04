package com.yves.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.yves.model.converter.ColorConverter;
import com.yves.model.field.CarColor;


/*
 * A regarder
 *  Auditing : http://www.baeldung.com/database-auditing-jpa
 *  
 *  Relation entre entites : http://blog.paumard.org/cours/jpa/chap03-entite-relation.html
 *  Tuto JPA : https://www.petrikainulainen.net/spring-data-jpa-tutorial/
 */



@NamedQueries({
	@NamedQuery(name = Car.FIND_ALL_NQ, query = "SELECT c FROM Car c order by c.plate ")
})
@Entity
@Table(name = "MYCAR")
public class Car {

	public static final String FIND_ALL_NQ = "com.yves.model.Car.find_all";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	// relations entre tables
	@OneToOne(mappedBy="car")
    private CarBrand brand;
	
	@OneToOne
    private FuelKind fuelKind;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "cars")
	private List<Driver> drivers = new ArrayList<>();
	
	// convertir les types chelou de bdd
	@Convert(converter = ColorConverter.class)
	private CarColor color;
	
	// Simple fields
	@NotEmpty
	private String plate;
	private String type;
	@Column(name = "les_chevals")
	private int horsePower;
	@Column(precision = 2, scale = 2)
	@Min(0)
	private int maxSpeed;
	private double fuelUsage;

	
	
	/*
	 *  Optimistic lock
	 *  
	 *  https://www.mkyong.com/jpa/jpa-optimistic-lock-exception-in-java-development/
	 * 	https://dzone.com/articles/version-based-optimistic
	 *	http://www.byteslounge.com/tutorials/locking-in-jpa-lockmodetype
	 */
	@Version
	private int version;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public CarBrand getBrand() {
		return brand;
	}


	public void setBrand(CarBrand brand) {
		this.brand = brand;
	}


	public FuelKind getFuelKind() {
		return fuelKind;
	}


	public void setFuelKind(FuelKind fuelKind) {
		this.fuelKind = fuelKind;
	}


	public List<Driver> getDrivers() {
		return drivers;
	}


	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}


	public CarColor getColor() {
		return color;
	}


	public void setColor(CarColor color) {
		this.color = color;
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


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", fuelKind=" + fuelKind + ", drivers=" + drivers + ", color="
				+ color + ", plate=" + plate + ", type=" + type + ", horsePower=" + horsePower + ", maxSpeed="
				+ maxSpeed + ", fuelUsage=" + fuelUsage + ", version=" + version + "]";
	}

}
