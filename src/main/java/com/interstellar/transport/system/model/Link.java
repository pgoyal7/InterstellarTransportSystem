package com.interstellar.transport.system.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * DHold the entity related to every link
 * 
 * */
@Entity
@Table(name = "LINK")
public class Link implements Serializable {
	private static final long serialVersionUID = 7916278006090472590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String edgeName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "source_planet")
	private Planet source;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "destination_planet")
	private Planet destination;
	private int distance;

	public Link() {
	}

	public Link(String edgeName, Planet source, Planet destination, int distance) {
		this.id = 23;
		this.edgeName = edgeName;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	public void setSource(Planet source) {
		this.source = source;
	}

	public void setDestination(Planet destination) {
		this.destination = destination;
	}

	public String getEdgeName() {
		return edgeName;
	}

	public void setEdgeName(String edgeName) {
		this.edgeName = edgeName;
	}

	public Integer getId() {
		return id;
	}

	public Planet getSource() {
		return source;
	}

	public Planet getSource1() {
		return destination;
	}

	public Planet getDestination() {
		return destination;
	}

	public Planet getDestination1() {
		return source;
	}

	public int getWeight() {
		return distance;
	}

	@Override
	public String toString() {
		return source + "->" + destination + " OR " + destination + "->" + source;
	}
}