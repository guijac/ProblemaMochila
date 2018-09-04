package br.usp.iaa.ep.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Guilherme
 *
 * Classe helper, para gerar valores aleat�rios do arquivo config[i].txt
 * para apoio na gera��o da massa de teste
 * 
 */

public class GeradorArquivo {
	
	private Random gerador = new Random();
	
	// Para o problema proposto, a capacidade sempre ser� "100"
	public int retornarCapacidade(){
		return 100;
	}
	
	// Quantidade aleat�ria para compor o peso dos itens, entre 10 e 50
	public int gerarPesoItem(){
		return gerador.nextInt(40)+10;
	}
	
	// Quantidade aleat�ria para compor o valor dos itens, entre 200 e 500
	public int gerarValorItem(){
		return gerador.nextInt(400)+200;
	}
	
	// Valor aleat�ria para quantidade de itens, entre 20 e 50 
	public int gerarQuantidadeItens(){
		return gerador.nextInt(30)+20;
	}

	/* gerando a massa para testes no template definido pelo EP
	  informa��es no arquivo config/README.txt */
	public void gerarArquivo(int quantidadeItens, int i){
	    try {
	    	
    		FileWriter arq = new FileWriter("config/config" + i + ".txt");
    	    PrintWriter gravarArq = new PrintWriter(arq);
    	    gravarArq.print(retornarCapacidade());
    	    gravarArq.println();
    	    gravarArq.print(quantidadeItens);
    	    gravarArq.println();
    	    
    	    // gravar n itens
    	    for (int j = 0; j < quantidadeItens; j++) {
	    	    gravarArq.print(j);
	    	    gravarArq.print("|");
	    	    gravarArq.print(gerarPesoItem());
	    	    gravarArq.print("|");
	    	    gravarArq.print(gerarValorItem());
	    	    gravarArq.println();
			}
    	    
    	    arq.close();
			
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel gerar o arquivo");
			e.printStackTrace();
		}
	}
}
