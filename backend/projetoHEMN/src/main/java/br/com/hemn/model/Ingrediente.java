package br.com.hemn.model;

public class Ingrediente {
	private int id_ing;
	private String nome_ing;
	private double unidade_medida_ing;
	
	public Ingrediente() {
		super();
	}

	public Ingrediente(int id_ing, String nome_ing, double unidade_medida_ing) {
		super();
		this.id_ing = id_ing;
		this.nome_ing = nome_ing;
		this.unidade_medida_ing = unidade_medida_ing;
	}

	public int getId_ing() {
		return id_ing;
	}

	public void setId_ing(int id_ing) {
		this.id_ing = id_ing;
	}

	public String getNome_ing() {
		return nome_ing;
	}

	public void setNome_ing(String nome_ing) {
		this.nome_ing = nome_ing;
	}

	public double getUnidade_medida_ing() {
		return unidade_medida_ing;
	}

	public void setUnidade_medida_ing(double unidade_medida_ing) {
		this.unidade_medida_ing = unidade_medida_ing;
	}

	@Override
	public String toString() {
		return "Ingrediente [id_ing=" + id_ing + ", nome_ing=" + nome_ing + ", unidade_medida_ing=" + unidade_medida_ing
				+ "]";
	}
}
