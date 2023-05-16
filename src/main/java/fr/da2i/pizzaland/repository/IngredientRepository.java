package fr.da2i.pizzaland.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.da2i.pizzaland.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    
}
