package com.interstellar.transport.system.model;

/*
 * Holds the data of the link coming from the database
 * 
 * */
public class LinkModel {

	private String linkName;
	private String sourcePlanet;
	private String targetPlanet;
	private String distance;

	public LinkModel() {
	}

	public LinkModel(String linkName, String sourcePlanet, String targetPlanet, String distance) {
		super();
		this.linkName = linkName;
		this.sourcePlanet = sourcePlanet;
		this.targetPlanet = targetPlanet;
		this.distance = distance;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getSourcePlanet() {
		return sourcePlanet;
	}

	public void setSourcePlanet(String sourcePlanet) {
		this.sourcePlanet = sourcePlanet;
	}

	public String getTargetPlanet() {
		return targetPlanet;
	}

	public void setTargetPlanet(String targetPlanet) {
		this.targetPlanet = targetPlanet;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

}
