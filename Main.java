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

//importando biblioteca para converter valores em long para data;
import java.text.SimpleDateFormat;

public class Main{
	public static ListaImagens lista;
	public static Resumo arquivoResumo;
	public static void main(String[] args) throws IOException{ //não sei direito utilizar throws, mas é o único jeito de carregar um arquivo...
		String pastaImagens = "imagens";
		lista = new ListaImagens(pastaImagens);
		arquivoResumo = new Resumo();
		salvarArquivo("Arquivos Desordenados","",lista.imagens);
		System.out.println("Quantidade de imagens na pasta \""+pastaImagens+"\": "+lista.imagens.size()); //Imprime na tela apenas a quantidade de arquivos que existem na pasta (Essa linha não faz nada no sistema apenas mostra informação para deixar mais fácil o debug.)

		System.out.println();

		//ordenações por tamanho da imagem
			//selection sort -- copie toda este código para usar outro método
			salvarArquivo("selection","tamanho",lista.imagens); //é só colocar essa linha para cada método de sort
			//fim selection sort

			//shell sort
			salvarArquivo("shell","tamanho",lista.imagens);
			//fim shell sort

			//insertion sort
			salvarArquivo("bubble","tamanho",lista.imagens);
			//insertion sort

			//bubble sort
			salvarArquivo("insertion","tamanho",lista.imagens);
			//bubble sort

			//Anchor sort (método próprio)
			salvarArquivo("anchor","tamanho",lista.imagens);
			//Anchor sort (método próprio)
		//ordenações por tamanho da imagem



		//ordenações por nome da imagem
		System.out.println("\nOrdenações por nome do arquivo:");
			//selection sort - Nome Imagem
			salvarArquivo("selection","nome",lista.imagens);
			//selection sort - Nome Imagem

			//shell sort
			salvarArquivo("shell","nome",lista.imagens);
			//fim shell sort

			//insertion sort
			salvarArquivo("bubble","nome",lista.imagens);
			//insertion sort

			//bubble sort
			salvarArquivo("insertion","nome",lista.imagens);

			//bubble sort

			//Anchor sort (método próprio)
			salvarArquivo("anchor","nome",lista.imagens);

			//Anchor sort (método próprio)
		//ordenações por nome da imagem
		System.out.println("\nPor favor, verifique a pasta relatorios para visualizar todos os dados.");
		Main.arquivoResumo.salvarArquivo();
	}

	private static void salvarArquivo(String nomeMetodo,String tipoOrdenacao, ArrayList<Imagem> imagensDesordenadas)  throws IOException{
		long tempoInicio = System.nanoTime();
		ArrayList<Imagem> imagens = Sorts.sort(nomeMetodo,tipoOrdenacao,imagensDesordenadas);
		float tempoGasto =((float) (System.nanoTime() - tempoInicio))/1000000000;


		Main.arquivoResumo.escreverResumoMetodo(nomeMetodo,tipoOrdenacao,tempoGasto);

		new File("relatorios/").mkdir(); //cria a pasta relatorios, se já não foi criada.
		FileWriter arquivo = new FileWriter("relatorios/"+nomeMetodo+(!tipoOrdenacao.isEmpty()?" - "+tipoOrdenacao:"")+".txt"); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
		PrintWriter gravarArquivo = new PrintWriter(arquivo); //um objeto feito para "Grava coisas no arquivo"


		gravarArquivo.println("Método "+nomeMetodo);
		gravarArquivo.printf("Tempo gasto: %.9f segundos.", tempoGasto);
		gravarArquivo.println();
		gravarArquivo.println();
		gravarArquivo.println("Arquivos ordenados:");
		System.out.printf("Tempo gasto "+nomeMetodo+": %.9f segundos.\n",tempoGasto);
		SimpleDateFormat conversorData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		for(int x=0;x<imagens.size();x++){
			gravarArquivo.printf("| %s |",conversorData.format(imagens.get(x).getDataModificacao()));
			gravarArquivo.printf(" %9d Bytes |",imagens.get(x).getTamanhoBytes());
			gravarArquivo.printf(" %-36s |",imagens.get(x).getNome());
			gravarArquivo.println();
		}

		arquivo.close(); //Fecha o arquivo (pelo que entendi é quase um save)
	}

}
