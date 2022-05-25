package com.iset.produits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatController {


    @Autowired
    ProduitService  produitService;



    @GetMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    modelMap.addAttribute("produit", new Produit());
    return "createProduit";
    }

    @GetMapping("/search")
    public String search(ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue = "10") int size,@RequestParam(name ="Keyword" ,defaultValue="") String Keyword ) {
        Page<Produit> prods = produitService.findByNomProduitContains(Keyword,page, size);
        modelMap.addAttribute("produits", prods);   
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);


        modelMap.addAttribute("word", Keyword);

        System.out.println(modelMap);
    return "listeProduits";    
    };

@RequestMapping("/saveProduit")
public String saveProduit(@Valid Produit produit,BindingResult bindingResult,ModelMap modelMap) throws ParseException
{
    if (bindingResult.hasErrors()) {
        return "createProduit";
        }

    Produit saveProduit = produitService.saveProduit(produit);
    String msg = "produit enregistré avec Id " +saveProduit.getIdProduit();
    modelMap.addAttribute("msg", msg);
    return "createProduit";
}


@RequestMapping("/ListeProduits")
public String listeProduits(ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue = "10") int size)
{
    Page<Produit> prods = produitService.getAllProduitsParPage(page, size);
    modelMap.addAttribute("produits", prods);
    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
return "listeProduits";
}


@RequestMapping("/supprimerProduit")
public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue = "10") int size)
{
Produit p= new Produit();
p.setIdProduit(id);
produitService.deleteProduit(p);


Page<Produit> prods = produitService.getAllProduitsParPage(page, size);
modelMap.addAttribute("produits", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeProduits";
}


@RequestMapping("/modifierProduit")
public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
{
Produit p= produitService.getProduit(id);


modelMap.addAttribute("produit", p);
return "editerProduit";
}


@RequestMapping("/updateProduit")
public String updateProduit(@ModelAttribute("produit") Produit produit,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
produit.setDateCreation(dateCreation);
produitService.updateProduit(produit);

modelMap.addAttribute("produit", produit);
return "editerProduit";
}


@RequestMapping("/index")
public String index(){
    return "index";
}



}
