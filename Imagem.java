/************************************************************************
 * Classe do objeto Imagem
 * Responsável Principal: Victor Perin
 *
 * A partir dessa classe serão criados os objetos dos arquivos,
 * então 1 objeto = 1 arquivo
 *
 * Objetivos desse objeto:
 *  -Receber nome do arquivo (Ex: "../1.jpg"); ok -- precisa de testes
 *  -Verificar se o arquivo em questão existe; ok -- precisa de testes
 * 	-Carregar nome da imagem; ok -- falta mostrar erro se for nulo
 * 	-Carregar tamanho da imagem; ok -- falta mostrar erro se tamanho for nulo
 * 	-Carregar outras informações (se existirem); Mandem idéia se tiverem...
 ************************************************************************/

//importa classe de arquivos -> http://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;


public class Imagem{
	//variáveis de objeto
	private String nomeArquivo; //nome do arquivo da imagem (teste.jpg)
	private long tamanhoBytes,//tamanho do arquivo em bytes (sim, tem um limite!)
	data; //data de morificação do arquivo, em formato long (tem que converter)

	//método construtor (carrega o local do arquivo: Ex: "nomePasta/teste.jpg")
	public Imagem(String localArquivo){
		File arquivo = new File(localArquivo); //cria um objeto do tipo file
		if(arquivo.exists() && arquivo.isFile()){ //verifica se o arquivo existe e se ele não é uma pasta
			this.nomeArquivo = arquivo.getName(); //define nomeArquivo como o nome do arquivo carregado (teste.jpg)
			this.tamanhoBytes =arquivo.length(); //define tamanhoBytes como o tamanho do arquivos em bytes.
			this.data = arquivo.lastModified(); // define data como a ultima data de modificação do arquivo
		}else if(!arquivo.isFile()){}//caso o arquivo seja um pasta, ele mostra esse erro.
		else{	//caso o arquivo não exista, ele mostra esse erro.
			System.out.println("Arquivo não pode ser carregado.");
		}
	}

	//getters
	public String getNome(){ //retorna no nome do arquivo (teste.jpg)
		return this.nomeArquivo;
	}
	public long getTamanhoBytes(){ //retorna o tamanho do arquio em bytes (324)
		return this.tamanhoBytes;
	}
	public long getDataModificacao(){
		return this.data;
	}

}
