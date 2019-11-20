package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "kunde")
@Entity
public class Kunde implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ALTE_KUNDE = 1;
	public static final int NEU_KUNDE = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // nicht alle DB unterstutzen id autoincrement
	@Column(name="id")
	private int kundenNummer = -1; 
//	private int id;
	private String vorname;
	private String nachname;
	private String email;
	@Column(unique = true)
	private String username;
	private String passwort;
	public Kunde() {
		// TODO Auto-generated constructor stub
	}
	
	public Kunde(int kundenNummer, String vorname, String nachname, String email, String username, String passwort) {
		this.kundenNummer = kundenNummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.username = username;
		this.passwort = passwort;
	}

	public int getKundenNummer() {
		return kundenNummer;
	}
	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	@Override
	public String toString() {
		return "Kunde [kundenNummer=" + kundenNummer + ", vorname=" + vorname + ", nachname=" + nachname + ", email="
				+ email + ", username=" + username + ", passwort=" + passwort + "]";
	}
	
}
