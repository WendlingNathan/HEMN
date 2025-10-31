package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query("SELECT e from Endereco e WHERE e.cidade_end = :cidade AND cidade_end = :bairro")
	List<Endereco> findByCidadeEnd(@Param("cidade") String cidade, @Param("bairro") String bairro);
}