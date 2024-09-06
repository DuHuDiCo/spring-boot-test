package com.curso_java.curso_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso_java.curso_java.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

}
