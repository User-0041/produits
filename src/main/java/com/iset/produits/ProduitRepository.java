package com.iset.produits;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProduitRepository extends JpaRepository<Produit, Long> {   
     
    List<Produit> findByNomProduit(String nom);
    Page<Produit> findByNomProduitContaining(String nom,Pageable page);
    @Query("select p from Produit p where p.nomProduit =:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix")Double prix);
    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie (Categorie categorie);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix ();
}
