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

import br.com.projeto.model.Vendas;
import br.com.projeto.repository.VendasRepository;


@RestController
public class VendasResource {	  
		@Autowired
		private VendasRepository er;

		@RequestMapping(value= {"/api/vendasgetall"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterEstoques()
		{
			List<Vendas> venda;
			venda = er.findAll();
			if (venda == null || venda.size() == 0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(venda);
			return ResponseEntity.status(HttpStatus.OK).body(venda);
		}
		
	
		@RequestMapping(value= {"/api/vendasget/{ra}"}, method = RequestMethod.GET)
		public ResponseEntity<?> obterVendasRa(@PathVariable("ra") int idRA )
		{
			Optional<Vendas> vendas = er.findById(idRA);
			if (vendas == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vendas);
			
			
			return ResponseEntity.status(HttpStatus.OK).body(vendas);
		}
		
		
		
		
		@RequestMapping(value= {"/api/vendasdelete/{ra}"}, method = RequestMethod.DELETE)
		public ResponseEntity<?> eliminarAlunosRa(@PathVariable("ra") Integer idRA )
		{
			if (!er.existsById(idRA) )
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
			er.deleteById(idRA);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}	

		
		

		
		
		@RequestMapping(value= {"/api/vendaspost"}, method = RequestMethod.POST)
		public ResponseEntity<?> criarvend(@RequestBody Vendas vendas)
		{
			if (er.existsById(vendas.getCod()))
				return ResponseEntity.status(HttpStatus.CONFLICT).body(vendas);
			er.save(vendas);
			return ResponseEntity.status(HttpStatus.CREATED).body(vendas);
		}
		
		
		
		@RequestMapping(value= {"/api/vendasput"}, method = RequestMethod.PUT)
		public ResponseEntity<?> alterarAlunosRa(@RequestBody Vendas venda )
		{
			Vendas vendaAtual = er.getOne(venda.getCod());
			if (vendaAtual == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(venda);
			
			vendaAtual.setCod(venda.getCod());
			vendaAtual.setQnt(venda.getQnt());
			vendaAtual.setDatavenda(venda.getDatavenda());
			vendaAtual.setCodpdt(venda.getCodpdt());
			vendaAtual.setValortotal(venda.getValortotal());
			
			er.save(vendaAtual);
			return ResponseEntity.status(HttpStatus.OK).body(vendaAtual);
			
		}
		
		
}