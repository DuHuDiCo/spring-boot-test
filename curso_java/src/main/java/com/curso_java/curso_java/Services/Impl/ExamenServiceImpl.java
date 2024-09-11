package com.curso_java.curso_java.Services.Impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.curso_java.curso_java.Models.Categoria;
import com.curso_java.curso_java.Models.Examen;
import com.curso_java.curso_java.Repository.ExamenRepository;
import com.curso_java.curso_java.Services.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen addExam(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen updateExam(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<Examen> getExams() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public Examen getExamById(Long examId) {
        return examenRepository.findById(examId).get();
    }

    @Override
    public void deleteExam(Long examId) {
        Examen examen = new Examen();
        examen.setExamenId(examId);
        examenRepository.delete(examen);
    }

    @Override
    public List<Examen> getExamsByCategory(Categoria categoria) {
        return examenRepository.findByCategoria(categoria);
    }

}
