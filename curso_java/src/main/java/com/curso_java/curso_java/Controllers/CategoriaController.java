package com.curso_java.curso_java.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso_java.curso_java.Models.Categoria;
import com.curso_java.curso_java.Services.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> saveCategory(@RequestBody Categoria categoria) {
        Categoria savedCategory = categoriaService.addCategory(categoria);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/{categoriaId}")
    public Categoria getCategoryById(@PathVariable Long categoriaId) {
        return categoriaService.getCategoryById(categoriaId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllcategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getCategories());
    }

    @PutMapping("/")
    public Categoria updateCategory(@RequestBody Categoria categoria) {
        return categoriaService.updateCategory(categoria);
    }

    @DeleteMapping("/{categoriaId}")
    public void deleteCategory(@PathVariable Long categoriaId) {
        categoriaService.deleteCategory(categoriaId);
    }

}
