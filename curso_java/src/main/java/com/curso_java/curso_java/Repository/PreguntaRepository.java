package com.curso_java.curso_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso_java.curso_java.Models.Examen;
import com.curso_java.curso_java.Models.Preguntas;
import java.util.*;

public interface PreguntaRepository extends JpaRepository<Preguntas, Long> {
    public Set<Preguntas> findByExamen(Examen examen);
}
