package org.training.clientui.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.clientui.beans.CommandeBean;

@RibbonClient(name = "microservice-commandes")
@FeignClient(name = "microservice-commandes")
@Component
public interface MicroserviceCommandeProxy {

    @PostMapping(value = "/microservice-commandes/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
}
