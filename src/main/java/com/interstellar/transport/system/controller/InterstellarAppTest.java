package com.interstellar.transport.system.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.interstellar.transport.system.dao.GetSessionFactory;
import com.interstellar.transport.system.model.Link;
import com.interstellar.transport.system.model.Planet;
import com.interstellar.transport.system.service.InterstellarSystemServiceImpl;

public class InterstellarAppTest {
	static {
		readFromFileAndImportIntoDB();
	}

	public static List<Link> readFromFileAndImportIntoDB() {
		String linkFileName = "interstellarFileSystem/links.txt";
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

	public List<Link> getNetworkInformation() {
		Session session = GetSessionFactory.getInstance().sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Link");
		List<Link> list = query.list();
		return list;
	}

	public int updateLinkInNetwork(String linkName, int updatedDistance) {
		int resultReturned = 0;
		Session session = GetSessionFactory.getInstance().sessionFactory.openSession();
		session.beginTransaction();
		String hql = "UPDATE Link set distance = :updatedDistance where edgeName = :linkName";
		Query updateLinkQuery = session.createQuery(hql);
		updateLinkQuery.setParameter("updatedDistance", updatedDistance);
		updateLinkQuery.setParameter("linkName", linkName);
		resultReturned = updateLinkQuery.executeUpdate();
		session.getTransaction().commit();

		return resultReturned;
	}

	public int deleteLinkFromNetwork(String linkName) {
		int resultReturned = 0;
		Session session = GetSessionFactory.getInstance().sessionFactory.openSession();
		session.beginTransaction();
		Query deleteLinkQuery = session.createQuery("DELETE Link WHERE edgeName =:linkName");
		deleteLinkQuery.setParameter("linkName", linkName);
		resultReturned = deleteLinkQuery.executeUpdate();
		session.getTransaction().commit();

		return resultReturned;
	}
}
