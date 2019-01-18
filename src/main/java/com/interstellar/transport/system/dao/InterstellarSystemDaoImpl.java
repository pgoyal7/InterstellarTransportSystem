package com.interstellar.transport.system.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.interstellar.transport.system.model.Link;

/*
 * Class to perform database related activities
 * 
 * */
@Repository("interstellarSystemDao")
public class InterstellarSystemDaoImpl implements InterstellarSystemDao {

	/*
	 * Retrieves the network information
	 * 
	 * */
	@Override
	public List<Link> getNetworkInformation() {
		Session session = GetSessionFactory.getInstance().sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Link");
		List<Link> list = query.list();
		return list;
	}

	/*
	 * Update the Link present in the network
	 * 
	 * */
	@Override
	public int updateLinkInNetwork(String linkName, int updatedDistance) {
		int resultReturned = 0;
		Session session = GetSessionFactory.getInstance().sessionFactory.openSession();
		session.beginTransaction();
		String hql = "UPDATE Link set distance = :updatedDistance where edgeName = :linkName";
		System.out.println("hql-->"+hql);
		Query updateLinkQuery = session.createQuery(hql);
		updateLinkQuery.setParameter("updatedDistance", updatedDistance);
		updateLinkQuery.setParameter("linkName", linkName);
		resultReturned = updateLinkQuery.executeUpdate();
		session.getTransaction().commit();

		return resultReturned;
	}

	/*
	 * Delete the Link from the network
	 * 
	 * */
	@Override
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
