/*
 * Mladjan Mihajlovic 
 * Programiranje internet aplikacija | Elektrotehnicki fakultet | Avgust 2018
 */
package utils;

import beans.Autobus;
import beans.GradskaLinija;
import beans.Karta;
import beans.KategorijaZaposlenja;
import beans.Korisnik;
import beans.Linija;
import beans.MedjugradskaLinija;
import beans.Polazak;
import beans.PolazakMedjugradska;
import beans.Poruka;
import beans.Prevoznik;
import beans.Stanica;
import beans.Vozac;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mlađan
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Korisnik.class);
        configuration.addAnnotatedClass(Vozac.class);
        configuration.addAnnotatedClass(Polazak.class);
        configuration.addAnnotatedClass(Stanica.class);
        configuration.addAnnotatedClass(Autobus.class);
        configuration.addAnnotatedClass(Prevoznik.class);
        configuration.addAnnotatedClass(Linija.class);
        configuration.addAnnotatedClass(GradskaLinija.class);
        configuration.addAnnotatedClass(MedjugradskaLinija.class);
        configuration.addAnnotatedClass(Poruka.class);
        configuration.addAnnotatedClass(Karta.class);
        configuration.addAnnotatedClass(KategorijaZaposlenja.class);
        configuration.addAnnotatedClass(PolazakMedjugradska.class);

       // try {
        sessionFactory = configuration.configure().buildSessionFactory();
        //}
       // catch (Exception e) {
       //     e.printStackTrace();
       // }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
