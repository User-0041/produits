package com.iset.produits;

import java.util.List;

import org.springframework.data.domain.Page;


public interface ProduitServiceinterface {
Produit saveProduit(Produit p);
Produit updateProduit(Produit p);
void deleteProduit(Produit p);
void deleteProduitById(Long id);
Produit getProduit(Long id);
List<Produit> getAllProduits();
Page<Produit> getAllProduitsParPage(int page, int size);
List<Produit> findByNomProduit(String nom);
public Page<Produit> findByNomProduitContains(String nom,int page,int size);
List<Produit> findByNomPrix (String nom, Double prix);
List<Produit> findByCategorie (Categorie categorie);
List<Produit> findByCategorieIdCat(Long id);
List<Produit> findByOrderByNomProduitAsc();
List<Produit> trierProduitsNomsPrix();

}
