package org.training.clientui.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.training.clientui.beans.ProductBean;

import java.util.List;

@FeignClient(name = "microservice-produits")
//va demander à Ribbon d'aller chercher automatiquement la liste des URL (et donc instances) de Microservice-produits disponibles.
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {
    @GetMapping(value = "/microservice-produits/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/microservice-produits/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}
