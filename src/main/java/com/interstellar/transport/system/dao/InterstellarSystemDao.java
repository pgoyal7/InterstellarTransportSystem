package com.interstellar.transport.system.dao;

import java.util.List;

import com.interstellar.transport.system.model.Link;

/*
 * Interface to perform database related actib=vities
 * 
 * */
public interface InterstellarSystemDao {

	List<Link> getNetworkInformation();

	int updateLinkInNetwork(String linkName, int updatedDistance);

	int deleteLinkFromNetwork(String linkName);
}