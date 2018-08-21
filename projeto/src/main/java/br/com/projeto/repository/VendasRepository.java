package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projeto.model.Vendas;


public interface VendasRepository extends JpaRepository<Vendas, Integer>{
}