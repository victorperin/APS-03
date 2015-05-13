//classe scanner para receber dados do teclado
import java.util.Scanner;

//import das classes de array e array list
import java.util.Arrays;
import java.util.ArrayList;

//importando biblioteca de leitura de arquivos
import java.io.File;

//biblioteca usada para randomizar o arquivo
import java.util.Collections;

public class ListaImagens{

  ArrayList<Imagem> imagens;
  ArrayList<String> nomesArquivos;
  String pastaImagens;

  public ListaImagens(String pastaImagens){
    Scanner entrada = new Scanner(System.in);

    File f; //cria um objeto arquivo para a pasta de imagens, para conseguir pegar o conteúdo da pasta
    this.nomesArquivos = new ArrayList<String>(); // cria um arraylist em branco para o nome dos arquivos
    boolean erro;
    do{
      erro=false;
      f = new File(pastaImagens);
      try {
          this.nomesArquivos.addAll(Arrays.asList(f.list())); //gera um ArrayList apenas com os nomes dos arquivos
        }
      catch(NullPointerException e){
        System.out.println("Erro, não existem arquivos na pasta "+ pastaImagens);

        System.out.print("Digite outra pasta para a pasta imagens:");
        pastaImagens = entrada.nextLine();
        if(pastaImagens.equals("")) System.exit(0);
        erro = true;
      }
    }while(erro==true);
    this.pastaImagens = pastaImagens;
    this.imagens = new ArrayList<Imagem>(); //cria um ArrayList (vazio) de Objetos Imagem (o que eu criei), É ESSE ARRAY LIST QUE VOCÊS VÃO USAR!
  }
  public ArrayList<Imagem> carregaImagens(){
    if(this.pastaImagens.substring(this.pastaImagens.length() - 1)!="/")this.pastaImagens += "/"; //checa se a pastaImagens tem uma "/" no final, se não tiver, adiciona

		for(int x=0;x<this.nomesArquivos.size();x++){ //esse for copia o ArrayList nomesArquivos para o ArrayList imagens
      Imagem imagem = new Imagem(pastaImagens+nomesArquivos.get(x));
      if(imagem.getNome()!=null) this.imagens.add(imagem);
		}
		Collections.shuffle(this.imagens);//Ramdomiza ordem dos arquivos
    return this.imagens;
  }

}
