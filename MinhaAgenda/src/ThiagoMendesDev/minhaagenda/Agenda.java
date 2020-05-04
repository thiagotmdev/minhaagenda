package ThiagoMendesDev.minhaagenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
	
	private Map<String, Contato> contatosMap = new TreeMap<String, Contato>();
	
	private Map<Character, List<Contato>> contatosPorLetrasMap = new TreeMap<Character, List<Contato>>();
	
	private ArquivoAgenda arquivo = new ArquivoAgenda();
	
	public Agenda() throws IOException{
		List<Contato> contatos = arquivo.ler();
		
		for(Contato contato : contatos) {
			try {
				inserir(contato);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void inserir(Contato contato) throws AgendaException, IOException {
		contato.validarDados();
		
		String nome = contato.getNome();
		if(contatosMap.containsKey(nome)) {
			throw new AgendaException("O contato " + " nome já existe");
		}
		
		contatosMap.put(nome, contato);
		
		char letraInicial = Character.toUpperCase(nome.charAt(0));
		List<Contato> contatosLetra = contatosPorLetrasMap.get(letraInicial);
		if(contatosLetra == null) {
			contatosLetra = new ArrayList<Contato>();
			contatosPorLetrasMap.put(letraInicial, contatosLetra);
		}
		
		contatosLetra.add(contato);
		
		arquivo.gravar(contatosMap.values());
	}
}
