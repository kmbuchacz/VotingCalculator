package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_candidate")
	private int idCandidate;
	@Column(name="name_candidate")
	private String name;
	@Column(name="party")
	private String party;
	@Column (name="candidate_votes")
	private int candidateVotes;
	
	
	public Candidate() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getParty() {
		return party;
	}


	public void setParty(String party) {
		this.party = party;
	}


	public int getCandidateVotes() {
		return candidateVotes;
	}


	public void setCandidateVotes(int candidateVotes) {
		this.candidateVotes = candidateVotes;
	}
	
	
}
