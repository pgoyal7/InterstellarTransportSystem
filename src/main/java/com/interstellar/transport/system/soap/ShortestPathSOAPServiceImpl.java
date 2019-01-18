package com.interstellar.transport.system.soap;

import javax.jws.WebService;

import com.interstellar.transport.system.model.ShortestPath;
import com.interstellar.transport.system.service.InterstellarSystemService;
import com.interstellar.transport.system.service.InterstellarSystemServiceImpl;

/*
 * SOAP service implementation to return the shortest path info
 * 
 * */
@WebService(endpointInterface="com.interstellar.transport.system.soap.ShortestPathSOAPService")
public class ShortestPathSOAPServiceImpl implements ShortestPathSOAPService {

	@Override
	public ShortestPath getShortestPath(String source, String target) {
		InterstellarSystemService interstellarSystemService = new InterstellarSystemServiceImpl();
		return interstellarSystemService.getShortestPath(source, target,
				interstellarSystemService.getNetworkInformation());
	}

}
