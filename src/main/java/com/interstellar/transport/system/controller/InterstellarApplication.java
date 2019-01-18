package com.interstellar.transport.system.controller;

import java.util.List;

import com.interstellar.transport.system.model.Link;

public class InterstellarApplication {

	public static void main(String[] args) throws Exception {
		InterstellarAppTest appTest = new InterstellarAppTest();
		//appTest.storeIntoDatabase(appTest.readFromFileAndImportIntoDB());
		List<Link> links = appTest.getNetworkInformation();
		int deleteRecord = appTest.deleteLinkFromNetwork("Edge_19");
		System.out.println(deleteRecord);
		links = appTest.getNetworkInformation();
		int updateRecord = appTest.updateLinkInNetwork("Edge_20", 209);
		System.out.println(updateRecord);
		links = appTest.getNetworkInformation();

	}

}