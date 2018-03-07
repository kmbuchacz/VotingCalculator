package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Candidate;

public class CandidateOperationsImpl  {
	SessionFactory Factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Candidate.class)
			.buildSessionFactory();
	
	


	public void upDateVotes(List<Integer> indexesThatNeedToGoUp) {
		
		
		Session session = Factory.getCurrentSession();
		
		session.beginTransaction();
		for(int i=0; i< indexesThatNeedToGoUp.size();i++ ) {
			int candidatewithNewVote = indexesThatNeedToGoUp.get(i);
			Candidate tempCandidate = session.get(Candidate.class, candidatewithNewVote);
			
			tempCandidate.setCandidateVotes(tempCandidate.getCandidateVotes()+1);
			
			session.save(tempCandidate);
			
		}
	session.getTransaction().commit();
	session.close();
	}

	public List <Candidate> getCandidateList(){
		
		Session session = Factory.getCurrentSession();

		session.beginTransaction();
		Query<Candidate> theQuery = session.createQuery("from Candidate", Candidate.class);

		List<Candidate> candidateList = theQuery.getResultList();

		session.getTransaction().commit();
		session.close();
		return candidateList;
		
	}
	
	
	
}
