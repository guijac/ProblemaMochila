package br.usp.iaa.ep.main;

import java.util.List;
import java.util.Scanner;

import br.usp.iaa.ep.mochila.Item;
import br.usp.iaa.ep.mochila.MochilaGulosa1;
import br.usp.iaa.ep.mochila.MochilaGulosa2;
import br.usp.iaa.ep.mochila.MochilaTentativaEErro;
import br.usp.iaa.ep.util.GeradorArquivo;
import br.usp.iaa.ep.util.LeitorArquivo;
import br.usp.iaa.ep.util.ImprimirHelper;

/**
 * 
 * Exerc�cio Programa da Disciplina ACH2002	Introdu��o � An�lise de Algoritmos
 * 
 * O problema da mochila booleana
 * <https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/mochila-bool.html>
 * 
 * @author Guilherme
 *
 * Classe main, respons�vel pelas chamadas principais do EP
 * 
 */

public class EP {
	
	/* O modo debug ir� controlar os tempos de execu��o do programa e tamb�m
	 * resolver o problema da mochila n vezes para cen�rios distintos que ter�o
	 * os resultados coletados e analisados posteriormente no relat�rio
	 */
	private final static boolean ehDebug = false;
	
	public static void main(String[] args) {
		
		if (ehDebug){
			executarModoDebug();
		}
		else{
			executarModoNormal(args);
		}

	}

	private static void executarModoNormal(String[] args) {
		
		// Ler o arquivo a partir do par�metro informado na execu��o (args)
		LeitorArquivo leitorArquivo = new LeitorArquivo();
		Scanner scanner = leitorArquivo.obterScanner("config/" + args[0]);
		
		// Obter capacidade e quantidade de itens da mochila
		final int capacidade = leitorArquivo.lerCapacidade(scanner);
		int quantidadeItens = leitorArquivo.lerQuantidadeItens(scanner);

		if (capacidade == 0 || quantidadeItens == 0){
			
			System.out.println("Capacidade da mochila ou quantidade de itens "+
					"nao podem ser iguais a zero!");
			
		}else{
			
			List<Item> listaItens = leitorArquivo.lerItens(scanner
														, quantidadeItens);
			MochilaGulosa1 mochilaGulosa1 = new MochilaGulosa1(capacidade);
			MochilaGulosa2 mochilaGulosa2 = new MochilaGulosa2(capacidade);
			MochilaTentativaEErro mochilaTentativaEErro = 
				new MochilaTentativaEErro(capacidade);
			
			/* A resolu��o � baseada em uma nova lista de itens, j� colocados
			 * considerando a capacidade da mochila */
			mochilaGulosa1.setListaItens(mochilaGulosa1.resolver(listaItens));
			mochilaGulosa2.setListaItens(mochilaGulosa2.resolver(listaItens));
			mochilaTentativaEErro.setListaItens(
					mochilaTentativaEErro.resolver(listaItens, 0));
			
			ImprimirHelper.exibir("Guloso 1 - ", mochilaGulosa1);
			ImprimirHelper.exibir("Guloso 2 - ", mochilaGulosa2);
			ImprimirHelper.exibir("Tentativa e Erro - ", mochilaTentativaEErro);
		}
		
	}
	
	private static void executarModoDebug() {
		
		for (int i = 0; i < 10; i++) {
			// Gerar os arquivos para a realiza��o dos testes
			GeradorArquivo geradorArquivo = new GeradorArquivo();
			geradorArquivo.gerarArquivo(geradorArquivo.gerarQuantidadeItens(), i);
			
			// Ler n arquivos a partir do iterador i
			LeitorArquivo leitorArquivo = new LeitorArquivo();
			Scanner scanner = leitorArquivo.obterScanner("config/config" + i + ".txt");
			
			// Obter capacidade e quantidade de itens da mochila
			final int capacidade = leitorArquivo.lerCapacidade(scanner);
			int quantidadeItens = leitorArquivo.lerQuantidadeItens(scanner);

			if (capacidade == 0 || quantidadeItens == 0){
				System.out.println("Capacidade da mochila ou quantidade de itens " +
						"nao podem ser iguais a zero!");
			}else{
				
				List<Item> listaItens = leitorArquivo.lerItens(scanner, quantidadeItens);
				MochilaGulosa1 mochilaGulosa1 = new MochilaGulosa1(capacidade);
				MochilaGulosa2 mochilaGulosa2 = new MochilaGulosa2(capacidade);
				MochilaTentativaEErro mochilaTentativaEErro = 
					new MochilaTentativaEErro(capacidade);
				
				// nanossegundo = 10^-9
				double tempoExecucaoGuloso1 = System.nanoTime();
				mochilaGulosa1.setListaItens(mochilaGulosa1.resolver(listaItens));
				tempoExecucaoGuloso1 = 
							System.nanoTime() - tempoExecucaoGuloso1;
				
				double tempoExecucaoGuloso2 = System.nanoTime();
				mochilaGulosa2.setListaItens(mochilaGulosa2.resolver(listaItens));
				tempoExecucaoGuloso2 = 
							System.nanoTime() - tempoExecucaoGuloso2;
				
				double tempoExecucaoTentativaEErro = System.nanoTime();
				mochilaTentativaEErro.setListaItens(
						mochilaTentativaEErro.resolver(listaItens, 0));
				tempoExecucaoTentativaEErro = 
							System.nanoTime() - tempoExecucaoTentativaEErro;
				
				/* Os tempos foram divididos por 1000000, para maior precis�o dos ms
				 * milissegundo = 10^-3 */
				 
				ImprimirHelper.exibirDebug(
						"Guloso 1 - ", mochilaGulosa1, tempoExecucaoGuloso1/1000000);
				ImprimirHelper.exibirDebug(
						"Guloso 2 - ", mochilaGulosa2, tempoExecucaoGuloso2/1000000);
				ImprimirHelper.exibirDebug(
						"Tentativa e Erro - "
						, mochilaTentativaEErro
						, tempoExecucaoTentativaEErro/1000000);
			}
		}
		
	}
	
}
