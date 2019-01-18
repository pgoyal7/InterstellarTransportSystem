package com.interstellar.transport.system.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interstellar.transport.system.model.Graph;
import com.interstellar.transport.system.model.Link;
import com.interstellar.transport.system.model.Planet;

/*
 * Utilty to calculate the shortest path
 * 
 * */
public class InterstellarShortestPathAlgorithmService {

	private final List<Link> links;
	private Set<Planet> settledNodes;
	private Set<Planet> unSettledNodes;
	private Map<Planet, Planet> predecessors;
	private Map<Planet, Integer> distance;

	public InterstellarShortestPathAlgorithmService(Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.links = new ArrayList<Link>(graph.getLinks());
	}

	/*
	 * Main execution method
	 * 
	 * */
	public void execute(Planet source) {
		settledNodes = new HashSet<Planet>();
		unSettledNodes = new HashSet<Planet>();
		distance = new HashMap<Planet, Integer>();
		predecessors = new HashMap<Planet, Planet>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Planet node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(Planet node) {
		List<Planet> adjacentNodes = getNeighbors(node);
		for (Planet target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)
					|| getShortestDistance(node) > getShortestDistance(target) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private int getDistance(Planet node, Planet target) {
		for (Link link : links) {
			if (link.getSource().equals(node) && link.getDestination().equals(target)
					|| link.getSource1().equals(node) && link.getDestination1().equals(target)) {
				return link.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Planet> getNeighbors(Planet node) {
		List<Planet> neighbors = new ArrayList<Planet>();
		for (Link link : links) {
			if (link.getSource().equals(node) && !isSettled(link.getDestination())) {
				neighbors.add(link.getDestination());
			} else if (link.getSource1().equals(node) && !isSettled(link.getSource())) {
				neighbors.add(link.getSource());
			}
		}
		return neighbors;
	}

	private Planet getMinimum(Set<Planet> Planetes) {
		Planet minimum = null;
		for (Planet Planet : Planetes) {
			if (minimum == null) {
				minimum = Planet;
			} else {
				if (getShortestDistance(Planet) < getShortestDistance(minimum)) {
					minimum = Planet;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Planet Planet) {
		return settledNodes.contains(Planet);
	}

	private int getShortestDistance(Planet destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<Planet> getPath(Planet target) {
		LinkedList<Planet> path = new LinkedList<Planet>();
		Planet step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}