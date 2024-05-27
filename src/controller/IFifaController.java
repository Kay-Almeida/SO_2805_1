package controller;

import java.io.IOException;
import br.org.Kay_Almeida.pilhastring.Pilha;
import model.Lista;

public interface IFifaController {
	
	public Pilha empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desmpilhaBonsBrasileiros(Pilha pilha) throws IOException;
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException;

}
