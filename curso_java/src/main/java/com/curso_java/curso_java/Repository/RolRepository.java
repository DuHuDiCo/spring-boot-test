package com.curso_java.curso_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso_java.curso_java.Models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
