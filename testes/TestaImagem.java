/************************************************************************
 * Arquivo de teste para a classe Imagem.java
 * para testar, mover o arquivo para a pasta superior!!!!
 ************************************************************************/

public class TestaImagem{
	public static void main(String[]args){
		Imagem imagem = new Imagem("testes/Arquivo de Testes.txt");
		System.out.println(imagem.getNome());
		System.out.println(imagem.getTamanhoBytes());
	}
}
