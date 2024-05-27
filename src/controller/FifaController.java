package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.org.Kay_Almeida.pilhastring.Pilha;
import model.Lista;

public class FifaController implements IFifaController {
	
	public FifaController() {
	}

	@Override
	public Pilha empilhaBrasileiros(String caminho, String nome) throws IOException {
		Pilha pilha = new Pilha(); 
		File arq = new File(caminho, nome);
	    if (arq.exists() && arq.isFile()) {
	        try (BufferedReader buffer = new BufferedReader(new FileReader(arq))) {
	            buffer.readLine(); 
	        	String linha;
	            while ((linha = buffer.readLine()) != null) {
	                String[] campos = linha.split(",");
	                if (campos[5].equals("Brazil")) {
	                	pilha.push(linha); 
	                }
	            }
	        }
	    }else {
	        throw new IOException("Arquivo Inválido");
	    }
		return pilha;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Pilha pilha) throws IOException {
		System.out.println("Lista de Jogadores Brasileiros com Overall maior que 80: ");
		while(!pilha.isEmpty()) {
			String linha = null;
			try {
				linha = pilha.pop();	
				String[] campos = linha.split(",");
				String nome = campos[2]; 
				int overall = Integer.parseInt(campos[7]); 
				if(overall>80) {
					System.out.println("Nome: " + nome + " - Overall: "+ overall );
				}		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
		Lista<String> lista = new Lista<String>(); 
		File arq = new File(caminho, nome);
	    if (arq.exists() && arq.isFile()) {
	        try (BufferedReader buffer = new BufferedReader(new FileReader(arq))) {
	            buffer.readLine(); 
	        	String linha;
	            while ((linha = buffer.readLine()) != null) {
	                String[] campos = linha.split(",");
	                int idade = Integer.parseInt(campos[3]); 
	                if (idade<=20) {
	                	if(lista.isEmpty()) {
	                	try {
							lista.addFirst(linha);
						} catch (Exception e) {
							e.printStackTrace();
						}
	                	}else {
	                		try {
								lista.addLast(linha);
							} catch (Exception e) {
								e.printStackTrace();
							}
	                	}
	                }
	            }
	        }
	    }
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
		System.out.println("Lista de Jogadores com Overall maior que 80 e com idade menor ou igual a 20: ");
		int tamanho = lista.size(); 
		while(!lista.isEmpty()) {
			String linha = null;
			try {
				linha = lista.get(tamanho-1);
				String[] campos = linha.split(",");
				String nome = campos[2]; 
                int idade = Integer.parseInt(campos[3]); 
				int overall = Integer.parseInt(campos[7]); 
				if(overall>80) {
					System.out.println("Nome: " + nome + " - Idade: "+ idade +" - Overall: "+ overall );
				}		
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				lista.removeLast();
			} catch (Exception e) {
				e.printStackTrace();
			}
			tamanho = lista.size(); 
		}
		}
		
	}


