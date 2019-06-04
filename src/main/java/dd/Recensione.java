package dd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


	@Entity
	@Table(name = "Blurecensioni")
	public class Recensione{
		@Id
		@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="RecGen")
		@SequenceGenerator(sequenceName="RECENSIONI_SEQ", allocationSize=1, name="RecGen")
		@Column(name = "recensioni_id")
		private int id_rec;
		@Column(name = "ristoranti_id")
		private int id_rest;
		@Column(name = "stelle")
		private int stelle;
		@Column(name = "utenti_id")
		private int id_ute;
		
		
		
		
		public Recensione(int id_rest, int stelle, int id_ute) {
			this.id_rest = id_rest;
			this.stelle = stelle;
			this.id_ute = id_ute;
		}
		
		public Recensione() {
			
		}
		public int getId_rec() {
			return id_rec;
		}
		public void setId_rec(int id_rec) {
			this.id_rec = id_rec;
		}
		public int getId_rest() {
			return id_rest;
		}
		public void setId_rest(int id_rest) {
			this.id_rest = id_rest;
		}
		public int getStelle() {
			return stelle;
		}
		public void setStelle(int stelle) {
			this.stelle = stelle;
		}
		public int getId_ute() {
			return id_ute;
		}
		public void setId_ute(int id_ute) {
			this.id_ute = id_ute;
		}
		
		
	}
	