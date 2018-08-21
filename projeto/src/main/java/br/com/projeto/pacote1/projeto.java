package br.com.projeto.pacote1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class projeto {

	 @RequestMapping("/index")
	public String index()
	{
	 return "index";
		
	}
	 
	 @RequestMapping("/vendedor")
	public String venderdor()
	{
	 return "vendedor";
		
	}
	 
	 
	 @RequestMapping("/estoquista")
	public String estoquista()
	{
	 return "estoquista";
		
	}
	 
	 
	 @RequestMapping("/funcionario")
	public String funcionario()
	{
	 return "funcionario";
		
	}
	 
	 	
}
