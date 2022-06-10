package com.baggio.lojavirtualbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baggio.lojavirtualbackend.model.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

}
