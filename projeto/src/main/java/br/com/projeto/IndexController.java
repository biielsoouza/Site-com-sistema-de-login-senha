package br.com.projeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController{
@RequestMapping(value = { "/estoque" }, method = RequestMethod.GET)
public ModelAndView getEstoque() {
	ModelAndView mv = new ModelAndView("estoquista");
	return mv;
}

@RequestMapping(value = { "/vendedor" }, method = RequestMethod.GET)
public ModelAndView getVendas() {
	ModelAndView mv = new ModelAndView("vendedor");
	return mv;
}

 @RequestMapping(value = {"/"}, method = RequestMethod.GET)
  public ModelAndView getIndex() {
	  ModelAndView mv = new ModelAndView("index");
	  return mv;
 }

 @RequestMapping(value = {"/funcionario"}, method = RequestMethod.GET)
 public ModelAndView getFuncionario() {
	  ModelAndView mv = new ModelAndView("funcionario");
	  return mv;
}

 

}

