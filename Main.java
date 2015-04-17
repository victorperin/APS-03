import java.util.Scanner;

//import das classes de array e array list
import java.util.Arrays;
import java.util.ArrayList;

//import exception
import java.io.IOException;

//importando biblioteca de arquivos
import java.io.PrintWriter;
import java.io.FileWriter;


public class Main{
	public static void main(String[] args) throws IOException{
		
		FileWriter arquivo = new FileWriter("blablabla.txt");
		PrintWriter gravarArquivo = new PrintWriter(arquivo);
		
		gravarArquivo.println("blebleble!");
		gravarArquivo.println("oi!");
		arquivo.close();
		
	}
	
}