package com.curso_java.curso_java.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso_java.curso_java.Models.Categoria;
import com.curso_java.curso_java.Models.Examen;
import com.curso_java.curso_java.Services.ExamenService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/examen")
@CrossOrigin("*")
public class ExamenController {

    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @PostMapping("/")
    public ResponseEntity<Examen> saveExam(@RequestBody Examen examen) {
        return ResponseEntity.ok(examenService.addExam(examen));
    }

    @PutMapping("/")
    public ResponseEntity<Examen> updateExam(@RequestBody Examen examen) {
        return ResponseEntity.ok(examenService.updateExam(examen));
    }

    @GetMapping("/")
    public ResponseEntity<?> getExams() {
        return ResponseEntity.ok(examenService.getExams());
    }

    @GetMapping("/{examenId}")
    public Examen getExamenById(@PathVariable("examenId") Long examenId) {
        return examenService.getExamById(examenId);
    }

    @DeleteMapping("/")
    public void deleteExam(@PathVariable("examenId") Long examenId) {
        examenService.deleteExam(examenId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Examen> getExamByCategory(@PathVariable("categoriaId") Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return examenService.getExamsByCategory(categoria);
    }

}
