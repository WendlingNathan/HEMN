package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposicaoProduto extends JpaRepository<ComposicaoProduto,Long>{
	List<ComposicaoProduto> findByIngredienteIdIng(int id_ing);
}
