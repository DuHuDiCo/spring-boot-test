package com.curso_java.curso_java.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso_java.curso_java.Models.Examen;
import com.curso_java.curso_java.Models.Preguntas;
import com.curso_java.curso_java.Services.ExamenService;
import com.curso_java.curso_java.Services.PreguntaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/pregunta")
@CrossOrigin("*")
public class PreguntaController {
    private final PreguntaService preguntaService;

    private final ExamenService examenService;

    public PreguntaController(PreguntaService preguntaService, ExamenService examenService) {
        this.preguntaService = preguntaService;
        this.examenService = examenService;
    }

    @PostMapping("/")
    public ResponseEntity<Preguntas> saveQuestion(@RequestBody Preguntas preguntas) {
        return ResponseEntity.ok(preguntaService.addQuestion(preguntas));
    }

    @PutMapping("/")
    public ResponseEntity<Preguntas> updateQuestion(@RequestBody Preguntas preguntas) {
        return ResponseEntity.ok(preguntaService.updateQuestion(preguntas));
    }

    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> getQuestionsByExam(@PathVariable("examenId") Long examenId) {
        Examen examen = examenService.getExamById(examenId);
        Set<Preguntas> preguntas = examen.getPreguntas();

        List examenes = new ArrayList(preguntas);
        if (examenes.size() > Integer.parseInt(examen.getNumeroPreguntas())) {
            examenes = examenes.subList(0, Integer.parseInt(examen.getNumeroPreguntas()) + 1);
        }

        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);

    }

}
