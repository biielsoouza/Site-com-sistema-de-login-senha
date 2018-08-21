package br.com.projeto.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Estoque;
import br.com.projeto.repository.EstoqueRepository;



@RestController
public class EstoqueResources {	  
		@Autowired
		private EstoqueRepository er;
	
	//OBTER ALUNOS!	
		
		
		@RequestMapping(value= {"/api/estoquegetall"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterEstoques()
		{
			List<Estoque> estoque;
			estoque = er.findAll();
			if (estoque == null || estoque.size() == 0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(estoque);
			return ResponseEntity.status(HttpStatus.OK).body(estoque);
		}
		
		@RequestMapping(value= {"/api/estoqueget/{ra}"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterEstoqueRa(@PathVariable("ra") int idRA )
		{
			Optional<Estoque> estoque = er.findById(idRA);
			if (estoque == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(estoque);
			
			
			return ResponseEntity.status(HttpStatus.OK).body(estoque);
		}
		
	//SALVAR ALUNOS
	/**	@param estoque
		 @return
	**/	
		@RequestMapping(value= {"/api/estoquepost"}, method = RequestMethod.POST)
		public ResponseEntity<?> salvarEstoqueCod(@RequestBody Estoque estoque)
		{
			if (er.existsById(estoque.getCod()))
				return ResponseEntity.status(HttpStatus.CONFLICT).body(estoque);
			er.save(estoque);
			return ResponseEntity.status(HttpStatus.CREATED).body(estoque);

		}	

 //Deletar Alunos

@RequestMapping(value= {"/api/estoquedelete/{ra}"}, method = RequestMethod.DELETE)
public ResponseEntity<?> eliminarEstoqueRa(@PathVariable("ra") Integer idRA )
{
	if (!er.existsById(idRA) )
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	er.deleteById(idRA);
	
	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
}	


@RequestMapping(value= {"/api/estoqueput"}, method = RequestMethod.PUT)
public ResponseEntity<?> alterarAlunosRa(@RequestBody Estoque estoque )
{
	Estoque EstoqueAtual = er.getOne(estoque.getCod());
	if (EstoqueAtual == null)
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(EstoqueAtual);
	
	EstoqueAtual.setCod(estoque.getCod());
	EstoqueAtual.setNome(estoque.getNome());
	EstoqueAtual.setQnt(estoque.getQnt());
	EstoqueAtual.setVali(estoque.getVali());
	EstoqueAtual.setValor(estoque.getValor());

	er.save(EstoqueAtual);
	return ResponseEntity.status(HttpStatus.OK).body(EstoqueAtual);
	
}



}
