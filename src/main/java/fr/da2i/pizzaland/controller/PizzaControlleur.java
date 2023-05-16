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

import fr.da2i.pizzaland.model.Pizza;
import fr.da2i.pizzaland.repository.PizzaRepository;

@RestController
public class PizzaControlleur {

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/pizzas")
    public ResponseEntity<List<Pizza>> getPizzas() {
        List<Pizza> pizzalist= pizzaRepository.findAll();
        if (pizzalist.isEmpty()){
            return new ResponseEntity<List<Pizza>>(HttpStatus.CONFLICT);
        }
        else{
            return new ResponseEntity<List<Pizza>>(pizzaRepository.findAll(),HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/pizzas/{id}")
    public ResponseEntity<Pizza> getPizza(@PathVariable Integer id) {
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        if (pizza == null){
            return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Pizza>(pizza,HttpStatus.ACCEPTED);
        }
    }


    @GetMapping("/pizzas/{id}/prixfinal")
    public ResponseEntity<Integer> newPizzas(@PathVariable Integer id) {
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        if (pizza == null){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Integer>(pizza.getPrix(),HttpStatus.ACCEPTED);
        }
    }   

    @PostMapping("/pizzas")
    public ResponseEntity<Pizza> insert(@RequestBody Pizza pizza)
    {
        try {
            pizzaRepository.save(pizza);
        } catch (Exception e) {
            return new ResponseEntity<Pizza>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Pizza>(pizza,HttpStatus.ACCEPTED);
    }
}