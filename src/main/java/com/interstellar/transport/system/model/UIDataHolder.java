package com.interstellar.transport.system.model;

import java.io.Serializable;

/*
 * Holds the UI data input by the user
 * 
 * */
public class UIDataHolder implements Serializable {

	private static final long serialVersionUID = 2055231709085173340L;
	
	private String sourcePlanet;
	private String destinationPlanet;
	private String linkName;
	private int distance;

	public UIDataHolder() {
	}
	
	public UIDataHolder(String sourcePlanet, String destinationPlanet, String linkName, int distance) {
		super();
		this.sourcePlanet = sourcePlanet;
		this.destinationPlanet = destinationPlanet;
		this.linkName = linkName;
		this.distance = distance;
	}

	public String getSourcePlanet() {
		return sourcePlanet;
	}

	public void setSourcePlanet(String sourcePlanet) {
		this.sourcePlanet = sourcePlanet;
	}

	public String getDestinationPlanet() {
		return destinationPlanet;
	}

	public void setDestinationPlanet(String destinationPlanet) {
		this.destinationPlanet = destinationPlanet;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}