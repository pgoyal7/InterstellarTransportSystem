package com.interstellar.transport.system.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Holds the details of the shortest path
 * 
 * */
@XmlRootElement
public class ShortestPath implements Serializable {

	private static final long serialVersionUID = 4944899484067557252L;

	private String sourcePlanet;
	private String destinationPlanet;
	private String shortestPath;

	public ShortestPath() {
	}

	public ShortestPath(String sourcePlanet, String destinationPlanet, String shortestPath) {
		super();
		this.sourcePlanet = sourcePlanet;
		this.destinationPlanet = destinationPlanet;
		this.shortestPath = shortestPath;
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

	public String getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(String shortestPath) {
		this.shortestPath = shortestPath;
	}
}
