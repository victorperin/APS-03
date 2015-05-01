/************************************************************************
 * Classe do objeto Sorts
 * Responsável Principal: Todo mundo
 * -- Cada um será responsável por criar um método dentro deste arquivo.
 *
 * Essa classe será a responsável por organizar os arquivos, independentemente
 * do tipo de sort.
 *
 * A classe é um conjunto de Métodos de Sort:
 *  -Recebe o ArrayList<imagem> imagens;
 *  -Retorna o ArrayList<imagem> imagensOrdenadas;
 ************************************************************************/
 import java.util.Arrays;
 import java.util.ArrayList;

public class Sorts{

  //método de exemplo
  //não se esqueça do "public static!"m mude apenas o nome exemplo sort e o comentario dentro do método...
  public static ArrayList<Imagem> exemploSort(ArrayList<Imagem> imagens){ //retorna um ArrayList de Imagem, mas usa 'imagens' como parametro
    //algoritimo de ordenação aqui
    imagens.get(0).getNome(); //se você for ordenar por nome, use esse método, lembre-se de usar um for e ao invés de 0 use uma variável (lembre-se isso é igual a um array)
    imagens.get(0).getTamanhoBytes(); //se for usar para ordenar por tamanho de arquivo (o mais fácil)
    return imagens;
  }

  public static ArrayList<Imagem> selectionSort(ArrayList<Imagem> imagens){
    for (int fixo = 0; fixo < imagens.size() - 1; fixo++) {
      int menor = fixo;

      for (int i = menor + 1; i < imagens.size(); i++){
        if (imagens.get(i).getTamanhoBytes() < imagens.get(menor).getTamanhoBytes()){
    		    menor = i;
        }
      }
      if (menor != fixo) {
      	// Troca
        Imagem t = imagens.get(fixo);
        imagens.set(fixo,imagens.get(menor));
        imagens.set(menor,t);
      }
    }
    return imagens;
  }

  //coloque outros métodos aqui
  
  // Shellsort GABI
  public static ArrayList<Imagem> shellSort(ArrayList<Imagem> imagens){
	  // cria laço de repetição para calcular o valor dos "pulos" (gap)
	  for(int gap = imagens.size()/2; gap > 0; gap /= 2){
		  
		  // laço de repetição para comparar e organizar os valores
		  for (int i = gap; i < imagens.size(); i++){ // percorrendo a lista

			  Imagem tempVal = imagens.get(i); // recebe o valor temporário que vai ser comparado
			  
			  int j; // variável para procurar o 2o valor a ser comparado
			  
			  // comparando os elementos
			  for (j = i; j >= gap && tempVal.getTamanhoBytes() < imagens.get(j - gap).getTamanhoBytes(); j -= gap){
				  imagens.set(j, imagens.get(j - gap)); // trocando...
			  }
			  imagens.set(j, tempVal); // trocando...
		  }
	  }
	  return imagens;
}
  public static ArrayList<Imagem> bubbleSort(ArrayList<Imagem> imagens){
  {
        imagens.get(0).getTamanhoBytes();

        boolean troca = true;
        Imagem aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < imagens.size() - 1; i++)
            {
                if (imagens.get(i).getTamanhoBytes() > imagens.get(i + 1).getTamanhoBytes() )
                {
                   aux = imagens.get(i);
                   imagens.set(i,imagens.get(i + 1));
                   imagens.set(i + 1,aux);
                   troca = true;
                }
            }
        }
  }
    return imagens;
  }

  public static ArrayList<Imagem> insertionSort(ArrayList<Imagem> imagens){
    for (int fixo = 0; fixo < imagens.size() - 1; fixo++) {
      int menor = fixo;

      for (int i = menor + 1; i < imagens.size(); i++){
        if (imagens.get(i).getTamanhoBytes() < imagens.get(menor).getTamanhoBytes()){
    		    menor = i;
        }
      }
      if (menor != fixo) {
      	// Troca
        Imagem t = imagens.get(fixo);
        imagens.set(fixo,imagens.get(menor));
        imagens.set(menor,t);
      }
    }
    return imagens;
  }
  
}
