package br.com.projeto.resources;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Login;
import br.com.projeto.repository.LoginRepository;


@RestController
public class LoginResource {	  
		@Autowired
		private LoginRepository er;

		@RequestMapping(value= {"/logar/{login}"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterLoginRa(@PathVariable("login") Integer idlogin)
		{
			Optional<Login> logar = er.findById(idlogin);
	
			if (logar == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(logar);
			
			return ResponseEntity.status(HttpStatus.OK).body(logar);
		}
}