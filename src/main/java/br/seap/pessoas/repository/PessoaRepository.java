package br.seap.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.seap.pessoas.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
