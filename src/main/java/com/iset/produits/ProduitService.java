package com.iset.produits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ProduitService implements ProduitServiceinterface {
@Autowired
ProduitRepository produitRepository;




@Override
public Produit saveProduit(Produit p) {
return produitRepository.save(p);
}



@Override
public Produit updateProduit(Produit p) {
return produitRepository.save(p);
}
@Override
public void deleteProduit(Produit p) {
produitRepository.delete(p);
}
@Override
public void deleteProduitById(Long id) {
produitRepository.deleteById(id);}


@Override
public Produit getProduit(Long id) {
return produitRepository.findById(id).get();
}
@Override
public List<Produit> getAllProduits() {
return produitRepository.findAll();
}

public Page<Produit> getAllProduitsParPage(int page, int size) {
    return produitRepository.findAll(PageRequest.of(page, size));
    
    }
@Override
public List<Produit> findByNomProduit(String nom) {
    return produitRepository.findByNomProduit(nom);
   
}
@Override
public Page<Produit> findByNomProduitContains(String nom,int page,int size) {
    return produitRepository.findByNomProduitContaining(nom,PageRequest.of(page, size));

}
@Override
public List<Produit> findByNomPrix(String nom, Double prix) {
    return produitRepository.findByNomPrix(nom, prix);
}
@Override
public List<Produit> findByCategorie(Categorie categorie) {
    return produitRepository.findByCategorie(categorie);
}
@Override
public List<Produit> findByCategorieIdCat(Long id) {
    return produitRepository.findByCategorieIdCat(id);
}
@Override
public List<Produit> findByOrderByNomProduitAsc() {
  return produitRepository.findByOrderByNomProduitAsc();
}
@Override
public List<Produit> trierProduitsNomsPrix() {
   return produitRepository.trierProduitsNomsPrix();
}
    
}
