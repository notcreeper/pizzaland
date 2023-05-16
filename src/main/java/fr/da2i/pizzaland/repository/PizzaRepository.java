package fr.da2i.pizzaland.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.da2i.pizzaland.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
