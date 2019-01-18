package com.interstellar.transport.system.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interstellar.transport.system.dao.InterstellarSystemDao;
import com.interstellar.transport.system.model.Graph;
import com.interstellar.transport.system.model.Link;
import com.interstellar.transport.system.model.Planet;
import com.interstellar.transport.system.model.ShortestPath;

/*
 * Service to provide the implementation of the business logic and model population
 * 
 * */
@Service("interstellarSystemService")
public class InterstellarSystemServiceImpl implements InterstellarSystemService {

	@Autowired
	private InterstellarSystemDao interstellarSystemDao;

	/*
	 * Returns the shortest path information
	 * 
	 * */
	@Override
	public ShortestPath getShortestPath(String source, String target, List<Link> links) {
		Graph graph = new Graph(links);
		InterstellarShortestPathAlgorithmService interstellarShortestPathAlgorithmService = new InterstellarShortestPathAlgorithmService(
				graph);
		interstellarShortestPathAlgorithmService.execute(new Planet(source));
		LinkedList<Planet> shortestPathList = interstellarShortestPathAlgorithmService.getPath(new Planet(target));
		StringBuilder shortestPathBuilder = new StringBuilder();
		for (Planet planetName : shortestPathList) {
			shortestPathBuilder.append(planetName).append("->");
		}
		String pathString = shortestPathBuilder
				.replace(shortestPathBuilder.length() - 2, shortestPathBuilder.length(), "").toString();

		ShortestPath shortestPath = new ShortestPath(source, target, pathString);
		return shortestPath;
	}

	/*
	 * Retrieves network information
	 * 
	 * */
	@Override
	public List<Link> getNetworkInformation() {
		return interstellarSystemDao.getNetworkInformation();
	}

	/*
	 * Update the Link in the network
	 * 
	 * */
	@Override
	public int updateLinkInNetwork(String linkName, int updatedDistance) {
		return interstellarSystemDao.updateLinkInNetwork(linkName, updatedDistance);
	}

	/*
	 * Delete the Link from the network
	 * 
	 * */
	@Override
	public int deleteLinkFromNetwork(String linkName) {
		return interstellarSystemDao.deleteLinkFromNetwork(linkName);
	}

}
