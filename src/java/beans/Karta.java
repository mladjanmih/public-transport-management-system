/*
 * Mladjan Mihajlovic 
 * Programiranje internet aplikacija | Elektrotehnicki fakultet | Avgust 2018
 */
package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Mlađan
 */
@Entity(name = "karte")
public class Karta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "polazak_id")
    private PolazakMedjugradska polazak;

    private Boolean odobrena;
    
    @Column(name = "datum_kupovine")
    private Date datumKupovine;
    
    @Column(name = "datum_vazenja")
    private Date datumVazenja;
    
    @Column(name = "admin_potvrdio")
    private Boolean adminPotvrdio;
    
    private Boolean tip; // 0 - gradski, 1 - medjugradski
    
    private Integer cena;
    
    public Karta() {
    }

    public Karta(Korisnik korisnik, Date datumKupovine, Boolean tip) {
        this.korisnik = korisnik;
        this.datumKupovine = datumKupovine;
        this.tip = tip;
        this.datumVazenja = null;
        this.adminPotvrdio = false;
        this.polazak = null;
        this.cena = 0;
    }

    public Karta(Korisnik korisnik, Date datumKupovine, Boolean tip, Integer cena) {
        this.korisnik = korisnik;
        this.datumKupovine = datumKupovine;
        this.tip = tip;
        this.cena = cena;
        this.datumVazenja = null;
        this.adminPotvrdio = false;
        this.polazak = null;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public PolazakMedjugradska getPolazak() {
        return polazak;
    }

    public void setPolazak(PolazakMedjugradska polazak) {
        this.polazak = polazak;
    }

    

    public Boolean getOdobrena() {
        return odobrena;
    }

    public void setOdobrena(Boolean odobrena) {
        this.odobrena = odobrena;
    }

    public Boolean getAdminPotvrdio() {
        return adminPotvrdio;
    }

    public void setAdminPotvrdio(Boolean adminPotvrdio) {
        this.adminPotvrdio = adminPotvrdio;
    }


    public Boolean getTip() {
        return tip;
    }

    public void setTip(Boolean tip) {
        this.tip = tip;
    }

    public Date getDatumKupovine() {
        return datumKupovine;
    }

    public void setDatumKupovine(Date datumKupovine) {
        this.datumKupovine = datumKupovine;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if (!this.tip) {
            sb.append("Kategorija korisnika: ").append(this.korisnik.getKategorijaZaposlenja().getNaziv()).append("\n")
                .append("Tip karte: ").append((this.korisnik.getKategorijaZaposlenja().isTip() ? "godišnja\n" : "mesečna\n"))
                .append("Cena karte: ").append(this.korisnik.getKategorijaZaposlenja().getCenaKarte());   
            if (this.datumVazenja != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                sb.append("\nVaži do: ").append(sdf.format(datumVazenja));
            }
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            sb.append("Prevoznik: ").append(this.polazak.getMedjugradskaLinija().getPrevoznik()).append("\n")
                    .append("Polaziste: ").append(this.polazak.getMedjugradskaLinija().getPolaznaStanica().getNaziv()).append("\n")
                    .append("Odrediste: ").append(this.polazak.getMedjugradskaLinija().getOdredisnaStanica().getNaziv()).append("\n")
                    .append("Vreme polaska: ").append(sdf.format(this.polazak.getVremePolaska()));
        }
        return sb.toString();
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Karta other = (Karta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
