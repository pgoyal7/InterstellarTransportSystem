package com.interstellar.transport.system.service;

import java.util.List;

import com.interstellar.transport.system.model.Link;
import com.interstellar.transport.system.model.ShortestPath;

public interface InterstellarSystemService {

	ShortestPath getShortestPath(String source, String target, List<Link> links);

//	List<Link> readFromFileAndImportIntoDB();
	
	List<Link> getNetworkInformation();
	int updateLinkInNetwork(String linkName, int updatedDistance);
	int deleteLinkFromNetwork(String linkName);
}
