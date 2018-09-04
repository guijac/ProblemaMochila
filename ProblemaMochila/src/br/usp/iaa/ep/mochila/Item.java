package br.usp.iaa.ep.mochila;

/**
 * @author Guilherme
 *
 * Classe responsável pela estrutura dos itens da mochila além do seu cálculo
 * de "custo/benefício", que será utilizado nas possíveis soluções
 * 
 */

public class Item implements Comparable<Item>{
	public double getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getCustoBeneficio() {
		return custoBeneficio;
	}
	public void setCustoBeneficio(int custoBeneficio) {
		this.custoBeneficio = custoBeneficio;
	}
	public int getNumeroItem() {
		return numeroItem;
	}
	public void setNumeroItem(int numeroItem) {
		this.numeroItem = numeroItem;
	}
	
	private int numeroItem;
	private int peso;
	private int valor;
	private int custoBeneficio;
	
	// Construtor padrão
	public Item(int numeroItem, int peso, int valor) {
		this.peso = peso;
		this.valor = valor;
		this.numeroItem = numeroItem;
		custoBeneficio = valor/peso;
	}
	@Override
	// A ordem natural será do maior custo-benefício, para o menor.
	public int compareTo(Item item) {
		if (this.custoBeneficio > item.custoBeneficio){
			return -1;
		}if (this.custoBeneficio < item.custoBeneficio){
			return 1;
		}
		return 0;
	}
	
}
