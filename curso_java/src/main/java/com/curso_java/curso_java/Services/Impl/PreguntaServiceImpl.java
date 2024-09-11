package com.curso_java.curso_java.Services.Impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.curso_java.curso_java.Models.Examen;
import com.curso_java.curso_java.Models.Preguntas;
import com.curso_java.curso_java.Repository.PreguntaRepository;
import com.curso_java.curso_java.Services.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Preguntas addQuestion(Preguntas preguntas) {
        return preguntaRepository.save(preguntas);
    }

    @Override
    public Preguntas updateQuestion(Preguntas preguntas) {
        return preguntaRepository.save(preguntas);
    }

    @Override
    public Set<Preguntas> getQuestions() {
        return (Set<Preguntas>) preguntaRepository.findAll();
    }

    @Override
    public Preguntas getQuestionById(Long preguntaId) {
        return preguntaRepository.findById(preguntaId).get();
    }

    @Override
    public Set<Preguntas> getQuestionsByExam(Examen examen) {
        return preguntaRepository.findByExamen(examen);
    }

    @Override
    public void deleteQuestion(Long preguntaId) {
        Preguntas preguntas = new Preguntas();
        preguntas.setPreguntaId(preguntaId);
        preguntaRepository.delete(preguntas);
    }

    @Override
    public Preguntas getPreguntas(Long preguntaId) {
        return preguntaRepository.getOne(preguntaId);
    }

}
