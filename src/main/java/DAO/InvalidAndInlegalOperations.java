package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.InvalidAndInlegal;

public class InvalidAndInlegalOperations {

	SessionFactory Factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(InvalidAndInlegal.class).buildSessionFactory();

	public void saveInvalid() {
		Session session = Factory.getCurrentSession();

		session.beginTransaction();

		InvalidAndInlegal counter = session.get(InvalidAndInlegal.class, 1);

		int invalidVotes = counter.getInvalidVotes();
		invalidVotes++;
		counter.setInvalidVotes(invalidVotes);

		session.save(counter);

		session.getTransaction().commit();
		session.close();

	}

	public void saveIllegal() {
		Session session = Factory.getCurrentSession();

		session.beginTransaction();

		InvalidAndInlegal counter = session.get(InvalidAndInlegal.class, 1);

		int illegalAttemps = counter.getIllegalAttempt();
		illegalAttemps++;
		counter.setIllegalAttempt(illegalAttemps);

		session.save(counter);

		session.getTransaction().commit();
		session.close();

	}

	public int getInvalidVotes() {
		Session session = Factory.getCurrentSession();

		session.beginTransaction();

		InvalidAndInlegal counter = session.get(InvalidAndInlegal.class, 1);

		int invalidVotes = counter.getInvalidVotes();

		session.getTransaction().commit();
		session.close();
		return invalidVotes;
	}
	
	
	public int getInlegalAttemps() {
		Session session = Factory.getCurrentSession();

		session.beginTransaction();

		InvalidAndInlegal counter = session.get(InvalidAndInlegal.class, 1);

		int illegalAttemps = counter.getIllegalAttempt();

		session.getTransaction().commit();
		session.close();
		return illegalAttemps;
	}
	
	
}
