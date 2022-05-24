package com.iset.produits;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long idCat;
    private String nomCat;
    private String DescriptionCat;
    @OneToMany(mappedBy ="categorie")
    private List<Produit> produits;
    public Categorie(String nomCat, String descriptionCat, List<Produit>produits) {
        this.nomCat = nomCat;
        this.DescriptionCat = descriptionCat;
        this.produits = produits;
    }
}
