package com.yves.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class FuelKind {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String name;
    
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

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "FuelKind [id=" + id + ", name=" + name + ", version=" + version + "]";
	}
}
