package Main;

import dao.ProdutoDao;
import model.Produto;

import java.util.Scanner;

public class Main {
	public static void main (String[] args ) {
		ProdutoDao produtoDao = new ProdutoDao ();
		Scanner scanner = new Scanner (System.in);
		
		String continuar = "sim";
		while (continuar.equalsIgnoreCase ("sim")) {
			
			//Solicitar dados do úsuario
			
			Produto produto = new Produto ();
			System.out.print ("Digite o nome do produto: ");
			produto.setNome (scanner.nextLine());
			
			System.out.print ("Digite o preco do produto: ");
			produto.setPreco (scanner.nextDouble());
			scanner.nextLine (); //Consumir a quebra de Linha
			
			//Criar o Produto
			produtoDao.criar (produto);
			
			System.out.print ("Deseja adicionar outro produto? (sim/nao): ");
			continuar = scanner.nextLine ();
		}
		
		//Listar todos os Produtos
		
		System.out.print ("\nLista de produtos no banco de dados:");
		produtoDao.listarTodos().forEach(p -> System.out.println (p.getNome() + " - " + p.getPreco()));
		
		scanner.close();
		
	}
}
