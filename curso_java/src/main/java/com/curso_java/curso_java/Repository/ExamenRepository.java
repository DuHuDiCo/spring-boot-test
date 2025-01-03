package com.curso_java.curso_java.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso_java.curso_java.Models.Categoria;
import com.curso_java.curso_java.Models.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {

    List<Examen> findByCategoria(Categoria categoria);

}
