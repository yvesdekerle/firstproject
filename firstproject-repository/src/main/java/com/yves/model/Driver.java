package com.yves.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String name;
    
    @ManyToMany
    @JoinTable(
      name="driver_cars",
      joinColumns=@JoinColumn(name="driver_id", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="car_id", referencedColumnName="id"))
    private List<Car> cars = new ArrayList<>();
    
    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", version=" + version + "]";
	}
}
