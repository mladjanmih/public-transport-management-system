/*
 * Mladjan Mihajlovic 
 * Programiranje internet aplikacija | Elektrotehnicki fakultet | Avgust 2018
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
/**
 *
 * @author Mlađan
 */
@Entity(name = "medjugradske_polasci")
public class PolazakMedjugradska implements Serializable {
    
    public PolazakMedjugradska() {
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "vreme_polaska")
    private Date vremePolaska;
    
    @Column(name = "vreme_dolaska")
    private Date vremeDolaska;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autobus_id")
    private Autobus autobus;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vozac_id")
    private Vozac vozac;
    
    @Column(name = "preostalo_mesta")
    private Integer preostaloMesta;
    
    @ManyToOne
    @JoinColumn(name = "medjugradska_linija_id", nullable = false)
    private MedjugradskaLinija medjugradskaLinija;
    
    @Transient
    private boolean korisnikRezervisao;
    
    @Transient
    private boolean otvoreneRezervacije;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Date getVremePolaska() {
        return vremePolaska;
    }

    public void setVremePolaska(Date vremePolaska) {
        this.vremePolaska = vremePolaska;
    }

    public Date getVremeDolaska() {
        return vremeDolaska;
    }

    public void setVremeDolaska(Date vremeDolaska) {
        this.vremeDolaska = vremeDolaska;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public Integer getPreostaloMesta() {
        return preostaloMesta;
    }

    public void setPreostaloMesta(Integer preostaloMesta) {
        this.preostaloMesta = preostaloMesta;
    }

    public MedjugradskaLinija getMedjugradskaLinija() {
        return medjugradskaLinija;
    }

    public void setMedjugradskaLinija(MedjugradskaLinija medjugradskaLinija) {
        this.medjugradskaLinija = medjugradskaLinija;
    }

    public boolean isKorisnikRezervisao() {
        return korisnikRezervisao;
    }

    public void setKorisnikRezervisao(boolean korisnikRezervisao) {
        this.korisnikRezervisao = korisnikRezervisao;
    }

    public boolean isOtvoreneRezervacije() {
        return otvoreneRezervacije;
    }

    public void setOtvoreneRezervacije(boolean otvoreneRezervacije) {
        this.otvoreneRezervacije = otvoreneRezervacije;
    }
     
}
