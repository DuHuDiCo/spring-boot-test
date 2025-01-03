package com.curso_java.curso_java.Services.Impl;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.curso_java.curso_java.Models.Categoria;
import com.curso_java.curso_java.Repository.CategoriaRepository;
import com.curso_java.curso_java.Services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria addCategory(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategory(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> getCategories() {
        List<Categoria> categoriasList = categoriaRepository.findAll();
        Set<Categoria> categorias = null;
        if(CollectionUtils.isEmpty(categoriasList)){
             categorias = new HashSet<>();
             return categorias;
        }
        
        categorias = new HashSet<>(categoriaRepository.findAll());

        return categorias;
    }

    @Override
    public Categoria getCategoryById(Long categoriaId) {
        return categoriaRepository.findById(categoriaId).get();
    }

    @Override
    public void deleteCategory(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        categoriaRepository.delete(categoria);
    }

}
