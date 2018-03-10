package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counter")
public class InvalidAndInlegal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_counter")
	private int id;
	@Column(name = "invalid_votes")
	private int invalidVotes;
	@Column(name = "illegal_attempt")
	private int illegalAttempt;

	public InvalidAndInlegal() {
	}

	public InvalidAndInlegal(int invalidVotes, int inlegalAttempt) {
		this.invalidVotes = invalidVotes;
		this.illegalAttempt = inlegalAttempt;
	}

	public int getInvalidVotes() {
		return invalidVotes;
	}

	public void setInvalidVotes(int invalidVotes) {
		this.invalidVotes = invalidVotes;
	}

	public int getIllegalAttempt() {
		return illegalAttempt;
	}

	public void setIllegalAttempt(int inlegalAttempt) {
		this.illegalAttempt = inlegalAttempt;
	}

}
