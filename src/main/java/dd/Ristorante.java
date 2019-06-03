package dd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "Ristoranti")
	public class Ristorante{
		@Id
		@Column(name = "ristoranti_id")
		private int id;
		@Column(name = "name")
		private String name;
		@Column(name = "posizione")
		private String posizione;
		@Column(name = "specialita")
		private String specialita;
		@Column(name = "recensione")
		private String recensione;
		public Ristorante(int id, String name, String posizione, String specialita, String recensione) {
			super();
			this.id = id;
			this.name = name;
			this.posizione = posizione;
			this.specialita = specialita;
			this.recensione = recensione;
		}
		
		public Ristorante() {
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
		public String getPosizione() {
			return posizione;
		}
		public void setPosizione(String posizione) {
			this.posizione = posizione;
		}
		public String getSpecialita() {
			return specialita;
		}
		public void setSpecialita(String specialita) {
			this.specialita = specialita;
		}
		public String getRecensione() {
			return recensione;
		}
		public void setRecensione(String recensione) {
			this.recensione = recensione;
		}
		
		
		
}

	
	