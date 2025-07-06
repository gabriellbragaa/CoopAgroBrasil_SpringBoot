package com.example.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.modelo.EstadoModelo;

public interface ModuloRepositorio extends JpaRepository<EstadoModelo, Long> {
	
}
