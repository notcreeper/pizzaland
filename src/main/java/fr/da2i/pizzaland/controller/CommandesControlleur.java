package fr.da2i.pizzaland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.da2i.pizzaland.model.Commande;
import fr.da2i.pizzaland.model.Pizza;
import fr.da2i.pizzaland.repository.CommandeRepository;

@RestController
public class CommandesControlleur {
    
    @Autowired
    CommandeRepository CommandeRepository;

    @GetMapping("/commandes/{id}")
    public ResponseEntity<Commande> getCommande(@PathVariable Integer id) {
        Commande commande = CommandeRepository.findById(id).orElse(null);
        if (commande == null){
            return new ResponseEntity<Commande>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Commande>(commande,HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/commandes/")
    public ResponseEntity<List<Commande>> getcommandes() {
        List<Commande> commande = CommandeRepository.findAll();
        if (commande.isEmpty()){
            return new ResponseEntity<List<Commande>>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Commande>>(commande,HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/commandes/{id}/prixfinal")
    public ResponseEntity<Integer> newcommandes(@PathVariable Integer id) {
        Commande commande = CommandeRepository.findById(id).orElse(null);
        if (commande == null){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
        else{
            Integer prix = 0;
            for (Pizza pizza : commande.getPizzas()){
                prix = prix + pizza.getPrix();
            }
            return new ResponseEntity<Integer>(prix,HttpStatus.ACCEPTED);
        }
       
    }


    @PostMapping("/commandes")
    public ResponseEntity<Commande> insert(@RequestBody Commande commande)
    {
        try {
            CommandeRepository.save(commande);
        } catch (Exception e) {
            return new ResponseEntity<Commande>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Commande>(commande,HttpStatus.ACCEPTED);
    }

}
