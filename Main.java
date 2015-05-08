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

//biblioteca usada para randomizar o arquivo
import java.util.Collections;

public class Main{
	public static int arquivosNaoCarregados = 0;
	public static void main(String[] args) throws IOException{ //não sei direito utilizar throws, mas é o único jeito de carregar um arquivo...
		Scanner entrada = new Scanner(System.in);

		long tempoInicio=System.nanoTime();

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
		Collections.shuffle(imagens);//Ramdomiza ordem dos arquivos

		System.out.println("Quantidade de imagens na pasta \""+pastaImagens+"\": "+(nomesArquivos.size()-arquivosNaoCarregados)); //Imprime na tela apenas a quantidade de arquivos que existem na pasta (Essa linha não faz nada no sistema apenas mostra informação para deixar mais fácil o debug.)
		System.out.print("Tempo para carregar os arquivos e desordena-los de forma aleatória: ");
		salvarArquivo("ArquivosDesordenados.txt",tempoInicio,imagens);
		System.out.println();

		//selection sort -- copie toda este código para usar outro método
		System.out.print("Tempo gasto SelectionSort:\t\t\t");
		salvarArquivo("SelectionSort.txt",System.nanoTime(),Sorts.selectionSort(imagens,1)); //é só colocar essa linha para cada método de sort
		//fim selection sort

		//shell sort
		System.out.print("Tempo gasto ShellSort:\t\t\t\t");
		salvarArquivo("ShellSort.txt",System.nanoTime(),Sorts.shellSort(imagens,1));
		//fim shell sort

		//insertion sort
		System.out.print("Tempo gasto InsertionSort:\t\t\t");
		salvarArquivo("InsertionSort.txt",System.nanoTime(),Sorts.insertionSort(imagens,1));
		//insertion sort

		//bubble sort
		System.out.print("Tempo gasto BubbleSort:\t\t\t\t");
		salvarArquivo("BubbleSort.txt",System.nanoTime(),Sorts.bubbleSort(imagens,1));
		//bubble sort

		//Ancor sort (método próprio)
		System.out.print("Tempo gasto AncorSort:\t\t\t\t");
		salvarArquivo("AncorSort.txt",System.nanoTime(),Sorts.ancorSort(imagens,1));
		//Ancor sort (método próprio)


		//ordenações por nome da imagem
		System.out.println("\nOrdenações por nome do arquivo:");
			//selection sort - Nome Imagem
			System.out.print("Tempo gasto SelectionSort:\t\t\t");
			salvarArquivo("SelectionSort - Por Nome.txt",System.nanoTime(),Sorts.selectionSort(imagens,2));
			//selection sort - Nome Imagem

			//shell sort
			System.out.print("Tempo gasto ShellSort:\t\t\t\t");
			salvarArquivo("ShellSort - Por Nome.txt",System.nanoTime(),Sorts.shellSort(imagens,2));
			//fim shell sort

			//insertion sort
			System.out.print("Tempo gasto InsertionSort:\t\t\t");
			salvarArquivo("InsertionSort - Por Nome.txt",System.nanoTime(),Sorts.insertionSort(imagens,2));
			//insertion sort

			//bubble sort
			System.out.print("Tempo gasto BubbleSort:\t\t\t\t");
			salvarArquivo("BubbleSort - Por Nome.txt",System.nanoTime(),Sorts.bubbleSort(imagens,2));

			//bubble sort

			//Ancor sort (método próprio)
			System.out.print("Tempo gasto AncorSort:\t\t\t\t");
			salvarArquivo("AncorSort - Por Nome.txt",System.nanoTime(),Sorts.ancorSort(imagens,2));

			//Ancor sort (método próprio)
		//ordenações por nome da imagem

	}

	private static void salvarArquivo(String nomeArquivo,long tempoInicio, ArrayList<Imagem> imagens)  throws IOException{
		FileWriter arquivo = new FileWriter(nomeArquivo); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
		PrintWriter gravarArquivo = new PrintWriter(arquivo); //um objeto feito para "Grava coisas no arquivo"

		float tempoGasto =((float) (System.nanoTime() - tempoInicio))/1000000000;
		gravarArquivo.printf("Tempo gasto: %.9f segundos.", tempoGasto);
		gravarArquivo.println();
		gravarArquivo.println();
		gravarArquivo.println("Arquivos ordenados:");
		System.out.printf("%.9f segundos.\n",tempoGasto);

		for(int x=0;x<imagens.size();x++){
			gravarArquivo.printf("%9d Bytes",imagens.get(x).getTamanhoBytes());
			gravarArquivo.println("\t\t"+imagens.get(x).getNome());
		}

		arquivo.close(); //Fecha o arquivo (pelo que entendi é quase um save)
	}

}
