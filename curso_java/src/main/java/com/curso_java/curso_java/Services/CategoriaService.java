package com.curso_java.curso_java.Services;

import com.curso_java.curso_java.Models.Categoria;
import java.util.*;

public interface CategoriaService {

    Categoria addCategory(Categoria categoria);

    Categoria updateCategory(Categoria categoria);

    Set<Categoria> getCategories();

    Categoria getCategoryById(Long categoriaId);

    void deleteCategory(Long categoriaId);

}
