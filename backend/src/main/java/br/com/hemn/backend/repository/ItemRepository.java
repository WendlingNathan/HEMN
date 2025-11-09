package br.com.hemn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
}