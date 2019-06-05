package dd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


	@Entity
	@Table(name = "Bluristoranti")
	public class Ristorante{
		@Id
		@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="RestGen")
		@SequenceGenerator(sequenceName="RISTORANTI_SEQ", allocationSize=1, name="RestGen")
		@Column(name = "ristoranti_id")
		private int id;
		@Column(name = "name")
		private String name;
		@Column(name = "posizione")
		private String posizione;
		@Column(name = "specialita")
		private String specialita;
		 

		public Ristorante(String name, String posizione, String specialita) {
			
			this.name = name;
			this.posizione = posizione;
			this.specialita = specialita;
			}
		
		public Ristorante(int id, String name, String posizione, String specialita) {
			
			this.id=id;
			this.name = name;
			this.posizione = posizione;
			this.specialita = specialita;
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
		
	
		
	
}

	
	