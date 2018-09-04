/**
 * 
 */
package br.usp.iaa.ep.mochila;

import java.util.List;

/**
 * @author Guilherme
 *
 * Classe abstrata que possui os atributos comuns aos diferentes tipos de 
 * mochilas utilizadas no EP
 *
 */
public abstract class Mochila {
	
	// Construtor padrão
    public Mochila(int capacidade){ 
        this.capacidade = capacidade; 
    }

	public List<Item> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public double getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	protected List<Item> listaItens;
	protected int capacidade;
	
	public abstract List<Item> resolver(List<Item> listaItens);
	
    /**
     * calcular o peso atual dos itens contidos na mochila
     *
     * @param List<Item> listaItens
     * @return double
     */
	public double calcularPeso(List<Item> listaItens){
		double pesoMochila = 0;
		if (listaItens != null){
			for (Item item : listaItens) {
				pesoMochila += item.getPeso();
			}
		}
		return pesoMochila;
	}
	
    /**
     * calcular o valor atual dos itens contidos na mochila
     *
     * @param List<Item> listaItens
     * @return double
     */
	public double calcularValor(List<Item> listaItens){
		double valorMochila = 0;
		if (listaItens != null){
			for (Item item : listaItens) {
				valorMochila += item.getValor();
			}
		}
		return valorMochila;
	}
}
