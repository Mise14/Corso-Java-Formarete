package it.fabio.MySpringRESTJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyUser {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id_user;
		private String nome;
		private String cognome;
		private int eta;
		
		public MyUser() {
		}
		
		public MyUser(String nome, String cognome, int eta) {
			this.nome = nome;
			this.cognome = cognome;
			this.eta = eta;
		}
		

		public int getId_user() {
			return id_user;
		}
		
		public void setId_user(int id_user) {
			this.id_user = id_user;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getCognome() {
			return cognome;
		}
		
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		
		public int getEta() {
			return eta;
		}
		
		public void setEta(int eta) {
			this.eta = eta;
		}
		@Override
		public String toString() {
			return "MyUser nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
		}
		

		
		
		 

	}
	
