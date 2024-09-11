package com.curso_java.curso_java.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/{preguntaId}")
    public Preguntas getQuestionById(@PathVariable("preguntaId") Long preguntaId) {
        return preguntaService.getQuestionById(preguntaId);
    }

    @DeleteMapping("/{preguntaId}")
    public void deleteQuestion(@PathVariable("preguntaId") Long preguntaId) {
        preguntaService.deleteQuestion(preguntaId);
    }

    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<Preguntas> preguntas) {
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for (Preguntas p : preguntas) {
            Preguntas pregunta = preguntaService.getPreguntas(p.getPreguntaId());
            if (pregunta.getRespuesta().equals(p.getRespuestaDada())) {
                respuestasCorrectas++;
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximos()) / preguntas.size();
                puntosMaximos += puntos;
            }
            if (p.getRespuestaDada() != null) {
                intentos++;
            }
        }

        Map<String, Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos", puntosMaximos);
        respuestas.put("respuestasCorrectas", respuestasCorrectas);
        respuestas.put("intentos", intentos);
        return ResponseEntity.ok(respuestas);
    }

}
