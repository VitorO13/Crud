package com.vitorprojects.projetocrud.infrastructure.repository;

import com.vitorprojects.projetocrud.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> deleteByEmail(String email);

}
//findBy e fixo email tem que corresponder
// com o que esta na classe user