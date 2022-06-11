package com.ensah.core.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Student {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String CNE;
		private String Nom;
		private String Prénom;
		private long id_niveau_actuel;
		private String type;

		public Student() {
			
		}

		public Student(long id) {
			super();
			this.id = id;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCNE() {
			return CNE;
		}
		public void setCNE(String cNE) {
			CNE = cNE;
		}
		public String getNom() {
			return Nom;
		}
		public void setNom(String nom) {
			Nom = nom;
		}
		public String getPrénom() {
			return Prénom;
		}
		public void setPrénom(String prénom) {
			Prénom = prénom;
		}
		public long getId_niveau_actuel() {
			return id_niveau_actuel;
		}
		public void setId_niveau_actuel(long id_niveau_actuel) {
			this.id_niveau_actuel = id_niveau_actuel;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", CNE=" + CNE + ", Nom=" + Nom + ", Prénom=" + Prénom + ", id_niveau_actuel="
					+ id_niveau_actuel + ", type=" + type + "]";
		}

		public Student(long id, String cNE, String nom, String prénom, long id_niveau_actuel, String type) {
			super();
			this.id = id;
			CNE = cNE;
			Nom = nom;
			Prénom = prénom;
			this.id_niveau_actuel = id_niveau_actuel;
			this.type = type;
		}

		public long getSniveau() {
			// TODO Auto-generated method stub
			return 0;
		}

			
			
		}

