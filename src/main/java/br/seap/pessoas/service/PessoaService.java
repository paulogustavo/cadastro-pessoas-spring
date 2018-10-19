package br.seap.pessoas.service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.seap.pessoas.models.Pessoa;
import br.seap.pessoas.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> buscar(Long id){
		if(id == null) {
			return pessoaRepository.findAll();
		} else {
			List<Pessoa> lista = new ArrayList<Pessoa>();
			Pessoa pessoa = pessoaRepository.findOne(id);
			lista.add(pessoa);
			return lista;
		}
	}
		
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void delete(Long idPessoa) {
		pessoaRepository.delete(idPessoa);
	}
	

}
