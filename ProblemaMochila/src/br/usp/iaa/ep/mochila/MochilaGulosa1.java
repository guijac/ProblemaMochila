package br.usp.iaa.ep.mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Guilherme
 *
 * Classe da solução gulosa nº1. O critério de "próximo passo" consiste em ordenar
 * os itens de melhor custo-benefício, através do método Collections.sort() (O(n*log(n)) 
 * do Java  e colocá-los na mochila.
 * 
 */

public class MochilaGulosa1 extends Mochila {

	public MochilaGulosa1(int capacidade) {
		super(capacidade);
	}

	public List<Item> resolver(List<Item> listaItens) {
    	List<Item> sol = new ArrayList<Item>();
    	Collections.sort(listaItens);
        int pesoAtual = 0;
        int posicao = 0;
        
        while (pesoAtual < capacidade && posicao < listaItens.size()){
        	Item item = listaItens.get(posicao);
            if(pesoAtual + item.getPeso() <= capacidade){
            	sol.add(item);
            	pesoAtual += item.getPeso();
            }
            posicao++;
        }
        
        return sol;
	}
	
}
