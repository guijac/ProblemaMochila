package br.usp.iaa.ep.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.usp.iaa.ep.mochila.Item;

/**
 * @author Guilherme
 *
 * Classe helper, encapsulando as principais operações para o tratamento de
 * leitura do arquivo
 * 
 */

public class LeitorArquivo {

	public List<Item> lerItens(Scanner scanner, int quantidadeItens){
		int n = 0;
		List<Item> listaItens = new ArrayList<Item>();
		while (scanner.hasNext() && n < quantidadeItens){
			Item item = new Item(Integer.parseInt(scanner.next().trim())
					,Integer.parseInt(scanner.next().trim())
					,Integer.parseInt(scanner.next().trim()));
			listaItens.add(item);
			n++;
		}
		return listaItens;
	}
	
	public int lerCapacidade(Scanner scanner){
		if (scanner.hasNext())
			return Integer.parseInt(scanner.next().trim());
		return 0;
	}
	
	public int lerQuantidadeItens(Scanner scanner){
		if (scanner.hasNext())
			return Integer.parseInt(scanner.next().trim());
		return 0;
	}
	
	public Scanner obterScanner(String arquivo){
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader(arquivo))
			.useDelimiter("\\||\\n");
			return scanner;
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não localizado");
			e.printStackTrace();
		}
		return null;
	}
}
