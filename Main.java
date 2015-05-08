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
	public static int arquivosNaoCarregados = 0;
	public static void main(String[] args) throws IOException{ //não sei direito utilizar throws, mas é o único jeito de carregar um arquivo...
		Scanner entrada = new Scanner(System.in);

		float tempoInicio=System.nanoTime();

		String pastaImagens = "imagens/"; //pasta onde os arquivos vão estar. (Matheus: Podemos colocar uma opção para o usuário digitar.)

		File f; //cria um objeto arquivo para a pasta de imagens, para conseguir pegar o conteúdo da pasta
		ArrayList<String> nomesArquivos = new ArrayList<String>();
		boolean erro;
		do{
			erro=false;
			f = new File(pastaImagens);
			try {
					nomesArquivos.addAll(Arrays.asList(f.list())); //gera um ArrayList apenas com os nomes dos arquivos
				}
			catch(NullPointerException e){
				System.out.println("Erro, não existem arquivos na pasta "+ pastaImagens);

				System.out.print("Digite outra pasta para a pasta imagens:");
				pastaImagens = entrada.nextLine();
				if(pastaImagens.equals("")) System.exit(0);
				erro = true;
			}
		}while(erro==true);



		ArrayList<Imagem> imagens = new ArrayList<Imagem>(); //cria um ArrayList (vazio) de Objetos Imagem (o que eu criei), É ESSE ARRAY LIST QUE VOCÊS VÃO USAR!

		if(pastaImagens.substring(pastaImagens.length() - 1)!="/")pastaImagens += "/"; //checa se a pastaImagens tem uma "/" no final, se não tiver, adiciona

		for(int x=0;x<nomesArquivos.size();x++){ //esse for copia o ArrayList nomesArquivos para o ArrayList imagens
			imagens.add(new Imagem(pastaImagens+nomesArquivos.get(x)));
		}

		System.out.println("Quantidade de imagens na pasta \""+pastaImagens+"\": "+(nomesArquivos.size()-arquivosNaoCarregados)); //Imprime na tela apenas a quantidade de arquivos que existem na pasta (Essa linha não faz nada no sistema apenas mostra informação para deixar mais fácil o debug.)
		salvarArquivo("ArquivosDesordenados.txt",imagens);
		float tempoCarregarArquivos = (System.nanoTime() - tempoInicio)/1000000000;
		System.out.printf("Tempo para carregar os arquivos (desordenado): \t%.9f segundos.\n",tempoCarregarArquivos);

		//selection sort -- copie toda este código para usar outro método
		tempoInicio = System.nanoTime();
		salvarArquivo("SelectionSort.txt",Sorts.selectionSort(imagens)); //é só colocar essa linha para cada método de sort
		System.out.printf("Tempo gasto SelectionSort:\t\t\t%.9f segundos.\n",(System.nanoTime() - tempoInicio)/1000000000);
		//fim selection sort

		//shell sort
		tempoInicio = System.nanoTime();
		salvarArquivo("ShellSort.txt",Sorts.shellSort(imagens));
		System.out.printf("Tempo gasto ShellSort:\t\t\t\t%.9f segundos.\n",(System.nanoTime() - tempoInicio)/1000000000);
		//fim shell sort
		
		//insertion sort
		tempoInicio = System.nanoTime();
		salvarArquivo("InsertionSort.txt",Sorts.insertionSort(imagens));
		System.out.printf("Tempo gasto InsertionSort:\t\t\t%.9f segundos.\n",(System.nanoTime() - tempoInicio)/1000000000);
		//insertion sort
	}

	private static void salvarArquivo(String nomeArquivo, ArrayList<Imagem> imagens)  throws IOException{
		FileWriter arquivo = new FileWriter(nomeArquivo); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
		PrintWriter gravarArquivo = new PrintWriter(arquivo); //um objeto feito para "Grava coisas no arquivo"

		for(int x=0;x<imagens.size();x++){
			gravarArquivo.print(imagens.get(x).getNome());
			gravarArquivo.println("\t"+imagens.get(x).getTamanhoBytes()+" Bytes");
		}
		arquivo.close(); //Fecha o arquivo (pelo que entendi é quase um save)
	}

}
