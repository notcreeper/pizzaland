package fr.da2i.pizzaland.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.da2i.pizzaland.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    
}
