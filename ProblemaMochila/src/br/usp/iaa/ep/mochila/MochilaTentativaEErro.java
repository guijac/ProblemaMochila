package br.usp.iaa.ep.mochila;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme
 *
 * Classe da solu��o backtracking, aqui tenta-se realizar todas combina��es 
 * poss�veis dos itens com apoio de um List auxiliar, que, caso seja a solu
 * ��o ideal, � retornado como solu��o.
 * 
 */

public class MochilaTentativaEErro extends Mochila {

	public MochilaTentativaEErro(int capacidade) {
		super(capacidade);
	}

	@Override
	public List<Item> resolver(List<Item> listaItens) {
		return null;
	}
	
	/* Atributos est�ticos para manterem os valores cumulativos durante as chamadas
	 recursivas do m�todo backtracking */
	public static List<Item> listaItensTMP = new ArrayList<Item>();
	public static List<Item> sol = new ArrayList<Item>();
	public static double valorMaximo = 0;
	
	public List<Item> resolver(List<Item> listaItens, int posicao) {
					
		double valorItensTMP = super.calcularValor(listaItensTMP);
		double pesoItensTMP = super.calcularPeso(listaItensTMP);

		if (posicao >= listaItens.size()) {
			if (valorItensTMP > valorMaximo) {
				valorMaximo = valorItensTMP;
				sol.clear();
				sol.addAll(listaItensTMP);
			}
			return sol;
		}
		
		Item item = listaItens.get(posicao);

		if (pesoItensTMP + item.getPeso() <= capacidade) {
			listaItensTMP.add(item);
			resolver(listaItens, posicao + 1);
			listaItensTMP.remove(item);
		}
		
		resolver(listaItens, posicao + 1);

		return sol;

	}
	
}
