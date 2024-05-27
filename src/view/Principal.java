package view;

import java.io.IOException;
import controller.FifaController;
import controller.IFifaController;

public class Principal {
	public static void main(String[] args) {
		
		IFifaController fifa = new FifaController(); 
		String caminho = "C:\\TEMP"; 
		String nome = "data.csv"; 
		
		try {
			fifa.desmpilhaBonsBrasileiros(fifa.empilhaBrasileiros(caminho, nome));
			fifa.buscaListaBonsJovens(fifa.listaRevelacoes(caminho, nome));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
}
