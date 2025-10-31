package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository <Ingrediente,Long>{
	List<Ingrediente> findByNomeIngContainingIgnoreCase(String nome_ing);

}
