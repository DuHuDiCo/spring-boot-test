package com.curso_java.curso_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso_java.curso_java.Models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
