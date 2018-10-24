package br.seap.pessoas.service;

import javax.transaction.Transactional;

import java.util.List;

import br.seap.pessoas.models.query.QPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.seap.pessoas.models.Pessoa;
import br.seap.pessoas.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa buscarPorId(Long id) {		

		return new QPessoa().id.eq(id).findOne();

	}
	
	public List<Pessoa> buscarTodas() {		
		return pessoaRepository.findAll();
	}
	
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void delete(Long idPessoa) {
		pessoaRepository.delete(idPessoa);
	}
	

}
