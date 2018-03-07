package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Client;
import Security.PeselHasher;

public class ClientOperationsImpl implements ClientOperations {

	SessionFactory Factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
			.buildSessionFactory();

	public void saveClient(Client tempClient) {
		Session session = Factory.getCurrentSession();

		session.beginTransaction();
		//hashing pesel
		
		String hashedPesel = PeselHasher.getHash(tempClient.getPesel().getBytes());
		tempClient.setPesel(hashedPesel);
		//pesel hashed
		
		session.save(tempClient);

		session.getTransaction().commit();
		session.close();

	}

	public List<Client> getClient() {

		Session session = Factory.getCurrentSession();

		session.beginTransaction();
		Query<Client> theQuery = session.createQuery("from Client", Client.class);

		List<Client> clientList = theQuery.getResultList();

		session.getTransaction().commit();
		session.close();

		return clientList;
	}

	public void updatePassedVoteColumn(Client tempClient) {

		Session session = Factory.getCurrentSession();

		session.beginTransaction();
		Query<Client> theQuery = session.createQuery("from Client", Client.class);

		List<Client> clientList = theQuery.getResultList();
		
		for( int i = 0; i<clientList.size(); i++) {
			if(clientList.get(i).getPesel().equals(tempClient.getPesel())){
				tempClient.setPassedVote(1);
				session.update(tempClient);
			}
		}
	

		session.getTransaction().commit();
		session.close();
	}

}
