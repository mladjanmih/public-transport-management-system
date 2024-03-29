/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import utils.ApplicationUtils;

/**
 *
 * @author Mlađan
 */

@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "linije")
public abstract class Linija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "polazna_stanica_id")
    private Stanica polaznaStanica;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odredisna_stanica_id")
    private Stanica odredisnaStanica;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @OrderColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Stanica> medjustanice;


    
    public Linija() {
        medjustanice = new ArrayList<Stanica>();
       
        
    }

    public Linija(Stanica polaznaStanica, Stanica odredisnaStanica, List<Stanica> medjustanice) {
        this.polaznaStanica = polaznaStanica;
        this.odredisnaStanica = odredisnaStanica;
        this.medjustanice = medjustanice;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Stanica getPolaznaStanica() {
        return polaznaStanica;
    }

    public void setPolaznaStanica(Stanica polaznaStanica) {
        this.polaznaStanica = polaznaStanica;
    }

    public Stanica getOdredisnaStanica() {
        return odredisnaStanica;
    }

    public void setOdredisnaStanica(Stanica odredisnaStanica) {
        this.odredisnaStanica = odredisnaStanica;
    }

    public List<Stanica> getMedjustanice() {
        return medjustanice;
    }

    public void setMedjustanice(List<Stanica> medjustanice) {
        this.medjustanice = medjustanice;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Linija other = (Linija) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
