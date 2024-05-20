package com.example.ms2_funcionaaa.Infrastracture;

import com.example.ms2_funcionaaa.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}