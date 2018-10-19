package br.seap.pessoas.controllers;

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

import br.seap.pessoas.models.Pessoa;
import br.seap.pessoas.service.PessoaService;

@RestController
public class PessoaController{
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value= {"pessoa", "pessoa/{id}"}, method=RequestMethod.GET)
	public Object read(@PathVariable Optional<Long> id) {
		return new ResponseEntity<List<Pessoa>>(pessoaService.buscar(id.get()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = {"pessoa"}, method= RequestMethod.POST)
	public Object create(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.save(pessoa),HttpStatus.OK);
	}
	
	@RequestMapping(value = {"pessoa"}, method= RequestMethod.PUT)
	public Object update(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.save(pessoa),HttpStatus.OK);
	}
	
	@RequestMapping(value = {"pessoa/{id}"}, method= RequestMethod.DELETE)
	public Object delete(@PathVariable("id") Long id) {
		pessoaService.delete(id);
		return "Registro apagado!";
	}
	
}