package com.curso_java.curso_java.Services;

import java.util.*;

import com.curso_java.curso_java.Models.Examen;
import com.curso_java.curso_java.Models.Preguntas;

public interface PreguntaService {

    Preguntas addQuestion(Preguntas preguntas);

    Preguntas updateQuestion(Preguntas preguntas);

    Set<Preguntas> getQuestions();

    Preguntas getQuestionById(Long preguntaId);

    Set<Preguntas> getQuestionsByExam(Examen examen);

    void deleteQuestion(Long preguntaId);

}
