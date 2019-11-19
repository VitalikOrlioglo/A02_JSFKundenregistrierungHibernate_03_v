package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import db.HibernateUtil;
import model.Kunde;

public class KundeHibernateDAO implements KundeDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Kunde findKunde(String usr, String pwd) {
		Session session = sf.getCurrentSession();
		session.beginTransaction(); // wird momentan von Query benutzt
		Query<Kunde> q = session.createQuery("FROM User WHERE username = :u AND passwort = :p", Kunde.class);
		q.setParameter("u", usr);
		q.setParameter("p", pwd);
		Kunde kunde = q.uniqueResult();
		session.close();
		
		return kunde;
	}

	@Override
	public boolean storeNewKunde(Kunde newKunde) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(newKunde);
		session.getTransaction().commit(); // jetzt save
		
		boolean ok = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		System.out.println("saved " + ok);
		
		session.close();
		return ok;
	}
	
	public static void main(String[] args) {
		KundeHibernateDAO dao = new KundeHibernateDAO();
//		dao.storeNewKunde(new Kunde(1, "Vitali", "Orlioglo", "vit@web.de", "vital", "123"));
		System.out.println(dao.findKunde("vital", ""));
		dao.sf.close();
	}
}
