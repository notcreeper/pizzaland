package fr.da2i.pizzaland.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.da2i.pizzaland.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByLogin(String username);
    
}
