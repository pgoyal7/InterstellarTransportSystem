package com.interstellar.transport.system.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.interstellar.transport.system.dao.GetSessionFactory;
import com.interstellar.transport.system.model.Link;
import com.interstellar.transport.system.model.LinkModel;
import com.interstellar.transport.system.model.Planet;
import com.interstellar.transport.system.model.ShortestPath;
import com.interstellar.transport.system.model.UIDataHolder;
import com.interstellar.transport.system.service.InterstellarSystemService;
import com.interstellar.transport.system.service.InterstellarSystemServiceImpl;

/**
 * Handles requests for the Interstellar System shortest path service.
 */
@Controller
@RequestMapping("/interstellar")
public class InterstellarSystemController {

	static {
		readFromFileAndImportIntoDB();
	}

	@Autowired
	private InterstellarSystemService interstellarSystemService;

	/*
	 * Calculate the shortest path between the earth and the other planet
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.GET_SHORTEST_PATH, method = RequestMethod.GET)
	public String getShortestPath(@ModelAttribute("shortestPathData") UIDataHolder shortestPathData, ModelMap model) {
		if (!shortestPathData.getSourcePlanet().equals("A")) {
			model.addAttribute("message","Source Planet should be A i.e. Earth");
			return "error";
		}
		ShortestPath shortestPathObject = interstellarSystemService.getShortestPath(shortestPathData.getSourcePlanet(),
				shortestPathData.getDestinationPlanet(), interstellarSystemService.getNetworkInformation());
		model.addAttribute("message",
				"The Shortest Path between " + shortestPathObject.getSourcePlanet() + "(Earth) and "
						+ shortestPathObject.getDestinationPlanet() + " is " + shortestPathObject.getShortestPath());

		return "shortestPathInfo";
	}

	/*
	 * Retrieves the network information from the database
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.GET_NETWORK_INFO, method = RequestMethod.GET)
	public String getNetworkInformation(ModelMap model) {
		List<LinkModel> networkData = new ArrayList<>();

		List<Link> linkList = interstellarSystemService.getNetworkInformation();
		for (Link link : linkList) {
			networkData.add(new LinkModel(link.getEdgeName(), link.getSource().getPlanetName() +" -> "+ link.getDestination().getPlanetName(),
					link.getSource1().getPlanetName() +" -> "+ link.getDestination1().getPlanetName(), Integer.valueOf(link.getWeight()).toString()));
		}

		model.addAttribute("networkInfo", networkData);

		return "networkInfo";
	}

	/*
	 * Delete the Link from the network
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.DELETE_LINK, method = RequestMethod.GET)
	public String deleteLinkFromNetwork(@ModelAttribute("linkInfo") UIDataHolder linkInfo, ModelMap model) {
		int recordDeleted = interstellarSystemService.deleteLinkFromNetwork(linkInfo.getLinkName());
		if (recordDeleted >= 1) {
			model.addAttribute("message", "Link has been successfully deleted");
			return "deleteSuccess";
		} else {
			model.addAttribute("message", "Link deletion has been failed");
			return "deleteFailed";
		}
	}

	/*
	 * Update the Link present in the network
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.UPDATE_LINK, method = RequestMethod.GET)
	public String updateLinkInNetwork(@ModelAttribute("updateDistanceInfo") UIDataHolder updateDistanceInfo,
			ModelMap model) {
		int recordUpdated = interstellarSystemService.updateLinkInNetwork(updateDistanceInfo.getLinkName(),
				updateDistanceInfo.getDistance());
		if (recordUpdated >= 1) {
			model.addAttribute("message", "Link has been successfully updated");
			return "updateSuccess";
		} else {
			model.addAttribute("message", "Link updation has been failed");
			return "updateFailed";
		}
	}

	/*
	 * Redirects to the update link page
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.UPDATE_LINK_PAGE)
	public String updateLinkPage() {
		return "updateLink";
	}

	/*
	 * Redirects to the delete link page
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.DELETE_LINK_PAGE)
	public String deleteLinkPage() {
		return "deleteLink";
	}
	
	/*
	 * Redirects to the shortest path link page
	 * 
	 */
	@RequestMapping(value = InterstellarTransportSystemURIConstants.GET_SHORTEST_PATH_LINK_PAGE)
	public String shortestPathLinkPage() {
		return "shortestPath";
	}

	/*
	 * Read the file and import it to the database
	 * 
	 */
	public static List<Link> readFromFileAndImportIntoDB() {
		String linkFileName = "interstellarFileSystem/links.txt";
		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		ClassLoader classLoader = InterstellarSystemServiceImpl.class.getClassLoader();
		List<Link> links = null;
		File file = null;
		try {
			file = new File(classLoader.getResource(linkFileName).getFile());
			// Read File Content
			String linkContent = new String(Files.readAllBytes(file.toPath()));
			List<String> linkList = Arrays.asList(linkContent.split("\n"));
			links = new ArrayList<>();
			for (String linkCreation : linkList) {
				String linkCreations[] = linkCreation.split(",");
				links.add(new Link(linkCreations[0], new Planet(linkCreations[1]), new Planet(linkCreations[2]),
						Integer.valueOf(linkCreations[3])));
			}
			storeIntoDatabase(links);
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.getMessage();
		} catch (IOException ioException) {
			ioException.getMessage();
		}

		return links;
	}

	/*
	 * Store the data in the database
	 * 
	 */
	public static void storeIntoDatabase(List<Link> links) {
		SessionFactory sessionFactory = GetSessionFactory.getInstance().sessionFactory;
		Session sessionLink = sessionFactory.openSession();

		sessionLink.beginTransaction();
		for (Link link : links) {
			sessionLink.save(link);
		}
		sessionLink.flush();
		sessionLink.getTransaction().commit();
	}
}
