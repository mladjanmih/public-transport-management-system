/*
 * Mladjan Mihajlovic 
 * Programiranje internet aplikacija | Elektrotehnicki fakultet | Avgust 2018
 */
package beans.managers;

import beans.Korisnik;
import beans.Poruka;
import java.util.List;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Mlađan
 */
public class KorisnikManager {

    public static Integer addKorisnik(Korisnik korisnik) {
        if (korisnik == null) {
            return null;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;
        Integer korisnikId = null;

        try {
            tx = session.beginTransaction();
            korisnikId = (Integer) session.save(korisnik);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }

        } finally {
            session.close();
        }

        return korisnikId;
    }

    public static Korisnik getKorisnikByUsername(String username) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Korisnik k = null;
        try {
            tx = session.beginTransaction();
            Query hqlQuery = session.createQuery("from korisnici where korisnicko_ime = :name");
            hqlQuery.setParameter("name", username);
            k = (Korisnik) hqlQuery.getSingleResult();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }

        } catch(NoResultException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } 
        finally {
            session.close();
        }

        return k;
    }
    
    public static void updateKorisnik(Korisnik k) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
             tx = session.beginTransaction();
             session.update(k);
             tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }

            ex.printStackTrace();
        } finally {
            session.close();
        }   
    }
    
    public static List<Korisnik> getZahteveZaRegistraciju() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List<Korisnik> korisnici = null;
         try {
            tx = session.beginTransaction();
            Query hqlQuery = session.createQuery("from korisnici where admin_potvrdio = false");
            
            korisnici = hqlQuery.getResultList();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return korisnici;
    }
}
