package com.example.ms2_funcionaaa.Infrastracture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ms2_funcionaaa.Domain.Compra;



@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
}