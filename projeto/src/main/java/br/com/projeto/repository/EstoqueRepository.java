package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Estoque;


public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
}   


