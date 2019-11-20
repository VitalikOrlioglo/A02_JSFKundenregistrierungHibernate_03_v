package dao;

import model.Kunde;

public interface KundeDAO {
	
	/**
	 * 
	 * @param usr
	 * @param pwd
	 * @return Kunde or Kunde with -1
	 */
	public Kunde findKunde(String usr, String pwd);
	public boolean storeNewKunde(Kunde newKunde); //speichert Kundendaten
	
}
