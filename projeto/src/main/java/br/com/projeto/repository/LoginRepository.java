package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projeto.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
}  