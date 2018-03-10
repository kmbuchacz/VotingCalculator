package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idclient")
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "pesel")
	private String pesel;
	@Column(name = "passed_vote")
	private int passedVote;

	public int isPassedVote() {
		return passedVote;
	}

	public void setPassedVote(int passedVote) {
		this.passedVote = passedVote;
	}

	public Client() {

	}

	public Client(String name, String surname, String pesel) {
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

}
