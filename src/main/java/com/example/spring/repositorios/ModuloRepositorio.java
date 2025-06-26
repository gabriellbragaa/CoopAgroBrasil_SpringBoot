package com.example.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.modelo.estadoModelo;

public interface ModuloRepositorio extends JpaRepository<estadoModelo, Long> {
	
}
