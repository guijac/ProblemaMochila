package br.usp.iaa.ep.mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.usp.iaa.ep.util.ValorComparator;

/**
 * @author Guilherme
 *
 * Classe da solu��o gulosa n�2. O crit�rio de "pr�ximo passo" consiste em ordenar
 * os itens de maior valor, atrav�s do m�todo Collections.sort() (O(n*log(n)) do Java  
 * e coloc�-los na mochila.
 * 
 */

public class MochilaGulosa2 extends Mochila {

	public MochilaGulosa2(int capacidade) {
		super(capacidade);
	}

	public List<Item> resolver(List<Item> listaItens) {
    	List<Item> sol = new ArrayList<Item>();
    	ValorComparator compararPorValor = new ValorComparator();
        Collections.sort(listaItens,compararPorValor);
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
