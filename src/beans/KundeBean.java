package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.KundeDAO;
import dao.KundeDummyDAO;
import dao.KundeHibernateDAO;
import dao.KundeMySQLDAO;
import model.Kunde;

@SessionScoped // "Lebensdauer" Fehler: NullPointerException
@ManagedBean
public class KundeBean {
	private Kunde kunde;
	private int KundenStatus;
	private KundeDAO dao;
	
	// wird aufgerufen nach dem Constructor
	@PostConstruct
	public void init() {
		kunde = new Kunde();
//		dao = new KundeDummyDAO();
//		dao = new KundeMySQLDAO();
		dao = new KundeHibernateDAO();
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public int getKundenStatus() {
		return KundenStatus;
	}
	public void setKundenStatus(int kundenStatus) {
		KundenStatus = kundenStatus;
	}
	
	/**
	 * // prüft, ob vorhanden.
	 * @return
	 */
	public String login() {
		kunde = dao.findKunde(kunde.getUsername(), kunde.getPasswort());
		if (kunde.getKundenNummer()==-1) {
			return "FormKunde";
		}
		return "ShowKunde";
	}
	
	/**
	 * - löst speichern aus
	 * TODO impl
	 * @return
	 */
	public String save() {
		boolean saved = dao.storeNewKunde(kunde);
		if (saved) {
			setKundenStatus(Kunde.ALTE_KUNDE);
			logout();
		}
		return "FormKunde"; 
	}
	
	public String logout() {
		setKunde(new Kunde());
		return "FormKunde";
	}
}
