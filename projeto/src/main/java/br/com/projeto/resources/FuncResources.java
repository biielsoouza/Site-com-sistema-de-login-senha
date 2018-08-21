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
import br.com.projeto.model.Func;
import br.com.projeto.repository.FuncRepository;

@RestController
public class FuncResources {	  
		@Autowired
		private FuncRepository er;

		//CONSULTAR
		
		@RequestMapping(value= {"/api/funcgetall"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterEstoques()
		{
			List<Func> func;
			func = er.findAll();
			if (func == null || func.size() == 0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(func);
			return ResponseEntity.status(HttpStatus.OK).body(func);
		}
		
		
		@RequestMapping(value= {"/api/funcget/{ra}"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterFuncsRa(@PathVariable("ra") int idRA )
		{
			Optional<Func> funcionario = er.findById(idRA);
			if (funcionario == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(funcionario);
			
			
			return ResponseEntity.status(HttpStatus.OK).body(funcionario);
		}
		
		
		//POST
		@RequestMapping(value= {"/api/funcpost"}, method = RequestMethod.POST)
		public ResponseEntity<?> salvarFuncCod(@RequestBody Func funcionario)
		{
			if (er.existsById(funcionario.getCodfunc()))
				return ResponseEntity.status(HttpStatus.CONFLICT).body(funcionario);
			er.save(funcionario);
			return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);

		}	
		
		
		//Delete
		@RequestMapping(value= {"/api/funcdelete/{ra}"}, method = RequestMethod.DELETE)
		public ResponseEntity<?> eliminarFuncionarioeRa(@PathVariable("ra") Integer idRA )
		{
			if (!er.existsById(idRA) )
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

			er.deleteById(idRA);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}	
		
		@RequestMapping(value= {"/api/funcput"}, method = RequestMethod.PUT)
		public ResponseEntity<?> alterarAlunosRa(@RequestBody Func func )
		{
			Func FuncAtual = er.getOne(func.getCodfunc());
			if (FuncAtual == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FuncAtual);
			
			FuncAtual.setCodfunc(func.getCodfunc());
			FuncAtual.setNome(func.getNome());
			FuncAtual.setData(func.getData());
			FuncAtual.setSalario(func.getSalario());
			FuncAtual.setCargo(func.getCargo());
			FuncAtual.setCpf(func.getCpf());
			
			er.save(FuncAtual);
			return ResponseEntity.status(HttpStatus.OK).body(FuncAtual);
			
		}
		
}