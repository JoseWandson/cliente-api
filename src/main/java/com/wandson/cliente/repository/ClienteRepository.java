package com.wandson.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandson.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
