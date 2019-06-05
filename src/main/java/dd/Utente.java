package dd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bluutenti")
public class Utente {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UserGen")
	@SequenceGenerator(sequenceName="UTENTI_SEQ", allocationSize=1, name="UserGen")
	@Column(name = "utenti_id")
	private int id;
	@Column(name = "utenti_nome")
	private String name;
	@Column(name = "utenti_cognome")
	private String cognome;
	
	
	
	
	public Utente(int id, String name, String cognome) {
		super();
		this.id = id;
		this.name = name;
		this.cognome = cognome;
	}

	public Utente(String name, String cognome) {
		super();
		this.name = name;
		this.cognome = cognome;
	}

	public Utente() {
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	
	
	
	
	
}

