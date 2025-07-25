package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findCategoryByCode(String code);

    // Optional<Object> findByCode(String code);
}
