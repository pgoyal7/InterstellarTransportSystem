package com.interstellar.transport.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Hold the entity related to planet
 * 
 * */
@Entity
@Table(name="PLANET")
public class Planet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="planetName")
	private String planetName;

	public Planet() {
	}

	public Planet(String planetName) {
		this.planetName = planetName;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planetName == null) ? 0 : planetName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (planetName == null) {
			if (other.planetName != null)
				return false;
		} else if (!planetName.equals(other.planetName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return planetName;
	}

}