package com.iset.produits.produits;


import java.util.Date;
import java.util.List;

import com.iset.produits.Categorie;
import com.iset.produits.Produit;
import com.iset.produits.ProduitRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class ProduitsApplicationTests {
@Autowired
private ProduitRepository produitRepository;
@Test
public void testCreateProduit() {
Produit prod = new Produit("PC Asus", 1500.500,  new Date());
produitRepository.save(prod);
}

@Test
public void testFindProduit()
{
Produit p = produitRepository.findById(9L).get();
System.out.println(p);
}

@Test
public void testUpdateProduit()
{
Produit p = produitRepository.findById(9L).get();
p.setPrixProduit(2000.0);
produitRepository.save(p);
System.out.println(p);
}


@Test
public void testDeleteProduit()
{
produitRepository.deleteById(9L);
}



@Test
public void testFindAllProduits()
{
List<Produit> prods = produitRepository.findAll();
for (Produit p:prods)
System.out.println(p);
}


@Test
public void testFindByNomProduit() {
    List<Produit> prods = produitRepository.findByNomProduit("iphoneX");
        for (Produit p : prods) {System.out.println("testFindByNomProduit " +p.getNomProduit());}
    }


@Test
public void testFindByNomProduitContains() {
    Page<Produit> prods =
    produitRepository.findByNomProduitContaining("Asus",PageRequest.of(1, 1));
        for (Produit p : prods) {System.out.println(p.getNomProduit());}
    }

@Test
public void testfindByNomPrix() {
    List<Produit> prods = produitRepository.findByNomPrix("iphoneX",1000.0);
    for (Produit p : prods) {System.out.println("testfindByNomPrix "+p);}
}

@Test
public void testfindByCategorie() {
    Categorie cat = new Categorie();
    cat.setIdCat(1L);
    List<Produit> prods = produitRepository.findByCategorie(cat);
    for (Produit p : prods) {
    System.out.println(p);
    }
}


@Test
public void findByCategorieIdCat() {
List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
for (Produit p : prods) {
System.out.println(p);
}
}
@Test
public void testfindByOrderByNomProduitAsc() {
List<Produit> prods =
produitRepository.findByOrderByNomProduitAsc();
for (Produit p : prods) {
System.out.println(p);
}
}

@Test
public void testTrierProduitsNomsPrix() {
List<Produit> prods = produitRepository.trierProduitsNomsPrix();
for (Produit p : prods) {
System.out.println(p);
}
}
}





