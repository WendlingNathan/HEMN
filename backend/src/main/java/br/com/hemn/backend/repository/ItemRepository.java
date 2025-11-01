package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Item;

	public interface ItemRepository extends JpaRepository<Item,Long>{
		List<Item> findById(int id_ite);
}
