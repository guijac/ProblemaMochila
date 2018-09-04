package br.usp.iaa.ep.util;

import java.util.Comparator;

import br.usp.iaa.ep.mochila.Item;

/**
 * @author Guilherme
 *
 * Classe do tipo Comparator, utilizada como segundo critério de ordenação
 * dos itens da mochila, aqui considera-se o maior valor como critério.
 * 
 */

public class ValorComparator implements Comparator<Item> {

	@Override
	// Ordenar do maior valor, para o menor.
	public int compare(Item arg0, Item arg1) {
		if (arg0.getValor() > arg1.getValor()){
			return -1;
		}if (arg0.getValor() < arg1.getValor()){
			return 1;
		}
		return 0;
	}

}
