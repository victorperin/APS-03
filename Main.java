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

//importando biblioteca de leitura de arquivos
import java.io.File;

//importando biblioteca de escrita de arquivos
import java.io.PrintWriter;
import java.io.FileWriter;


public class Main{
	public static void main(String[] args) throws IOException{ //não sei direito utilizar throws, mas é o único jeito de carregar um arquivo...

		String pastaImagens = "imagens/"; //pasta onde os arquivos vão estar. (Matheus: Podemos colocar uma opção para o usuário digitar.)

		File f = new File(pastaImagens); //cria um objeto arquivo para a pasta de imagens, para conseguir pegar o conteúdo da pasta
		ArrayList<String> nomesArquivos = new ArrayList<String>(Arrays.asList(f.list())); //gera um ArrayList apenas com os nomes dos arquivos
		System.out.println(nomesArquivos.size()); //Imprime na tela apenas a quantidade de arquivos que existem na pasta (Essa linha não faz nada no sistema apenas mostra informação para deixar mais fácil o debug.)

		ArrayList<Imagem> imagens = new ArrayList<Imagem>(); //cria um ArrayList (vazio) de Objetos Imagem (o que eu criei), É ESSE ARRAY LIST QUE VOCÊS VÃO USAR!


		for(int x=0;x<nomesArquivos.size();x++){ //esse for copia o ArrayList nomesArquivos para o ArrayList imagens
			imagens.add(new Imagem(pastaImagens+nomesArquivos.get(x)));
		}

		//o código que linka o código de cada classe de ordenação de cada um virá aqui!
		//favor retornar o ArrayList das imagens ordenadas

		salvarArquivo("SelectionSort.txt",Sorts.selectionSort(imagens)); //é só colocar essa linha para cada método de sort
		salvarArquivo("ShellSort.txt",Sorts.shellSort(imagens));

	}

	private static void salvarArquivo(String nomeArquivo, ArrayList<Imagem> imagens)  throws IOException{
		FileWriter arquivo = new FileWriter(nomeArquivo); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
		PrintWriter gravarArquivo = new PrintWriter(arquivo); //um objeto feito para "Grava coisas no arquivo"

		for(int x=0;x<imagens.size();x++){
			gravarArquivo.print(imagens.get(x).getNome());
			gravarArquivo.println("\t\t"+imagens.get(x).getTamanhoBytes()+" Bytes");
		}
		arquivo.close(); //Fecha o arquivo (pelo que entendi é quase um save)
	}

}
