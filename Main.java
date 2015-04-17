/************************************************************************
 * Classe principal do projeto
 * Responsável Principal: Victor Perin
 *
 * No momento o programa só cria um arquivo "blablabla.txt" e
 * escreve algum texto.
 * 
 * O objetivo dessa tela é fazer o passo-a-passo:
 * 	-Carregar todas as classes;
 * 	-Carregar todos os arquivos de uma pasta específica;
 * 	-Executar todos os algoritimos de ordenação (um de cada vez);
 * 	-Medir o tempo de cada algoritimo.
 ************************************************************************/

import java.util.Scanner;

//import das classes de array e array list
import java.util.Arrays;
import java.util.ArrayList;

//import exception (Necessária para a biblioteca de arquivos)
import java.io.IOException;

//importando biblioteca de arquivos 
import java.io.PrintWriter;
import java.io.FileWriter;


public class Main{
	public static void main(String[] args) throws IOException{ //não sei direito utilizar throws, mas é o único jeito de carregar um arquivo...
		
		FileWriter arquivo = new FileWriter("blablabla.txt"); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
		PrintWriter gravarArquivo = new PrintWriter(arquivo); //um objeto feito para "Grava coisas no arquivo"
		
		gravarArquivo.println("blebleble!"); //Grava uma linha no arquivo e desce para outra linha (Não consegui inserir \n, quem puder verificar, é de boa ajuda...)
		gravarArquivo.println("oi!");
		arquivo.close(); //Fecha o arquivo (pelo que entendi é quase um save)
		
	}
	
}
