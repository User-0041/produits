package com.iset.produits;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idProduit;
    @NonNull
    @Size(min = 4,max = 15)
    private String nomProduit;
    @Min(value = 10)
    @Max(value = 10000)
    private Double prixProduit;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation;    
    @ManyToOne
    private Categorie categorie;
    public Produit(String nomProduit, double prixProduit, Date dateCreation) {
        this.nomProduit=nomProduit;
        this.prixProduit=prixProduit;
        this.dateCreation=dateCreation;


    }
    public String toString(){
        return this.nomProduit+""+this.prixProduit+""+this.dateCreation;
    }

}
