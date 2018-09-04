package br.usp.iaa.ep.util;

import br.usp.iaa.ep.mochila.Item;
import br.usp.iaa.ep.mochila.Mochila;

/**
 * @author Guilherme
 *
 * Classe "helper" para impressão em tela dos principais atributos utilizados no EP
 * 
 */

public class ImprimirHelper {
	
	public static void exibir(double capacidade, int quantidadeItens, Mochila mochila) {
		int n = 1;
		
		System.out.println("Quantidade de Itens: " + quantidadeItens);
		System.out.println("Capacidade da Mochila: " + capacidade);
		
		for (Item item : mochila.getListaItens()) {
			System.out.println("Item " + n + ": Peso: " + item.getPeso() + 
					" Valor: " + item.getValor() + " Custo-Beneficio: " + 
					item.getCustoBeneficio());
			n++;
		}
		
		System.out.println("Peso Total: " + mochila.calcularPeso(mochila.getListaItens()));
		System.out.println("Valor Total: " + mochila.calcularValor(mochila.getListaItens()));
	}
	
	public static void exibir(String solucao, Mochila mochila) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(solucao);
		buffer.append("Indices colocados: ");
		for (Item item : mochila.getListaItens()) {
			buffer.append(item.getNumeroItem() + " ");
		}
		buffer.append("Peso Total: " + mochila.calcularPeso(mochila.getListaItens()));
		buffer.append(" Valor Total: " + mochila.calcularValor(mochila.getListaItens()));
		
		System.out.println(buffer.toString());
	}
	
	public static void exibirDebug(String solucao, Mochila mochila, double tempoExecucao) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(solucao);
		buffer.append("Indices colocados: ");
		for (Item item : mochila.getListaItens()) {
			buffer.append(item.getNumeroItem() + " ");
		}
		buffer.append("Peso Total: " + mochila.calcularPeso(mochila.getListaItens()));
		buffer.append(" Valor Total: " + mochila.calcularValor(mochila.getListaItens()));
		buffer.append(" Tempo Total: " + tempoExecucao);
		
		System.out.println(buffer.toString());
	}
}
