package com.theburgery.pos_restaurant.repository;

import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * 
     * @param name
     * @return
     */
    boolean existsByName(String name);

    Optional<Category> findByName(String name);
}
