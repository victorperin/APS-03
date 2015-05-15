//import exception (Necessária para a biblioteca de arquivos)
import java.io.IOException;

//importando biblioteca de leitura de arquivos
import java.io.File;

//importando biblioteca de escrita de arquivos
import java.io.PrintWriter;
import java.io.FileWriter;


public class Resumo{
  FileWriter arquivo;
  PrintWriter gravarArquivo;
  String nomeResumo,metodoMaisRapido,tipoOrdenacao;
  float menorTempo;

  public Resumo()  throws IOException{
    this.nomeResumo = "relatorios/Resumo.txt";
    this.arquivo = new FileWriter(this.nomeResumo); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
    this.gravarArquivo = new PrintWriter(this.arquivo); //um objeto feito para "Grava coisas no arquivo"
  }
  public void escreverResumoMetodo(String nomeMetodo, String tipoOrdenacao,float tempoCarregamento,long quantidadeOperacoes){
    this.gravarArquivo.println("Método: "+nomeMetodo);
    this.gravarArquivo.println("Tipo de Ordenação: "+tipoOrdenacao);
    this.gravarArquivo.printf("Tempo de Carregamento: %.9f",tempoCarregamento);
    this.gravarArquivo.println();
    this.gravarArquivo.print("Quantidade de Operações: "+quantidadeOperacoes);
    this.gravarArquivo.println();
    this.gravarArquivo.println();
    if(tempoCarregamento<this.menorTempo||this.menorTempo==0.0f){
      this.metodoMaisRapido = nomeMetodo + " - " + tipoOrdenacao;
      this.menorTempo = tempoCarregamento;

    }
  }
  public void salvarArquivo()  throws IOException{
    this.gravarArquivo.println();
    this.gravarArquivo.println();
    this.gravarArquivo.println("Método Mais rapido: "+this.metodoMaisRapido);
    System.out.println("Método Mais rapido: "+this.metodoMaisRapido);
    System.out.println("Veja mais informações no arquivo "+this.nomeResumo);
    this.arquivo.close();
  }
}
