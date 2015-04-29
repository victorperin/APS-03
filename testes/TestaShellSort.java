/************************************************************************
 * Arquivo de teste para a classe Imagem.java
 * para testar, mover o arquivo para a pasta superior!!!!
 ************************************************************************/
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;

public class TestaShellSort{
	public static void main(String[]args){

		String pastaImagens = "imagens/"; //pasta onde os arquivos vão estar. (Matheus: Podemos colocar uma opção para o usuário digitar.)

		File f = new File(pastaImagens); //cria um objeto arquivo para a pasta de imagens, para conseguir pegar o conteúdo da pasta
		ArrayList<String> nomesArquivos = new ArrayList<String>(Arrays.asList(f.list())); //gera um ArrayList apenas com os nomes dos arquivos
		System.out.println(nomesArquivos.size()); //Imprime na tela apenas a quantidade de arquivos que existem na pasta (Essa linha não faz nada no sistema apenas mostra informação para deixar mais fácil o debug.)

		ArrayList<Imagem> imagens = new ArrayList<Imagem>(); //cria um ArrayList (vazio) de Objetos Imagem (o que eu criei), É ESSE ARRAY LIST QUE VOCÊS VÃO USAR!

		for(int x=0;x<nomesArquivos.size();x++){ //esse for copia o ArrayList nomesArquivos para o ArrayList imagens
			imagens.add(new Imagem(pastaImagens+nomesArquivos.get(x)));
		}
		ArrayList<Imagem> imagensOrdenadas = Sorts.shellSort(imagens);

		for(int x=0;x<imagens.size();x++){ //esse for copia o ArrayList nomesArquivos para o ArrayList imagens
			System.out.println(imagens.get(x).getNome()+"\t\t"+imagens.get(x).getTamanhoBytes()+" Bytes");
		}

	}
}
