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
import org.springframework.web.server.ResponseStatusException;

import fr.da2i.pizzaland.model.Ingredient;
import fr.da2i.pizzaland.repository.IngredientRepository;

@RestController
public class IngredientsControlleur {
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredients(@PathVariable Integer id) {
        Ingredient ingredients = ingredientRepository.findById(id).orElse(null);
        if (ingredients == null){
            return new ResponseEntity<Ingredient>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Ingredient>(ingredients,HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>>  getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if (ingredients.isEmpty()){
            return new ResponseEntity<List<Ingredient>>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Ingredient>>(ingredients,HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> insert(@RequestBody Ingredient ingredients){
        try {
            ingredientRepository.save(ingredients);
            return new ResponseEntity<Ingredient>(ingredients,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<Ingredient>(HttpStatus.CONFLICT);
        }
    }
}
