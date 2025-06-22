package com.example.spring.agro;

import org.springframework.data.jpa.repository.JpaRepository;

// informar o tipo de dados do banco
public interface AgroRepository extends JpaRepository<Agro, Long> {}
