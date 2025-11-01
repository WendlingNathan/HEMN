package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	List<Funcionario>FindByNomeFuncContainingIgnoreCase(String nome_fun);
}
