package org.training.clientui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.clientui.beans.CommandeBean;
import org.training.clientui.beans.ProductBean;
import org.training.clientui.proxies.MicroserviceCommandeProxy;
import org.training.clientui.proxies.MicroserviceProduitsProxy;

import java.util.Date;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private MicroserviceProduitsProxy produitsProxy;

    @Autowired
    private MicroserviceCommandeProxy CommandesProxy;

    @RequestMapping("/")

    public String accueil(Model model) {
        List<ProductBean> produits = produitsProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        return "Accueil";

    }
    @RequestMapping("/details-produit/{id}")

    public String ficheProduit(@PathVariable int id, Model model){
        ProductBean produit = produitsProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }

    @RequestMapping(value = "/commander-produit/{idProduit}/{montant}")
    public String passerCommande(@PathVariable int idProduit, @PathVariable Double montant,  Model model){


        CommandeBean commande = new CommandeBean();

        //On renseigne les propriétés de l'objet de type CommandeBean que nous avons crée
        commande.setProductId(idProduit);
        commande.setQuantite(1);
        commande.setDateCommande(new Date());

        //appel du microservice commandes grâce à Feign et on récupère en retour les détails de la commande créée, notamment son ID (étape 4).
        CommandeBean commandeAjoutee = CommandesProxy.ajouterCommande(commande);

        //on passe à la vue l'objet commande et le montant de celle-ci afin d'avoir les informations nécessaire pour le paiement
        model.addAttribute("commande", commandeAjoutee);
        model.addAttribute("montant", montant);

        //return "Paiement";
        return "Accueil";
    }
}
