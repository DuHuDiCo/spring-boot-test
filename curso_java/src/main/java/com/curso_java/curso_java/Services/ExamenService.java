package com.curso_java.curso_java.Services;

import com.curso_java.curso_java.Models.Categoria;
import com.curso_java.curso_java.Models.Examen;

import java.util.List;
import java.util.Set;

public interface ExamenService {

    Examen addExam(Examen examen);

    Examen updateExam(Examen examen);

    Set<Examen> getExams();

    Examen getExamById(Long examId);

    void deleteExam(Long examId);

    List<Examen> getExamsByCategory(Categoria categoria);

    List<Examen> getExamenActive();

}
