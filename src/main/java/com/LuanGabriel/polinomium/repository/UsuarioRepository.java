package com.LuanGabriel.polinomium.repository;

import com.LuanGabriel.polinomium.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    
}
