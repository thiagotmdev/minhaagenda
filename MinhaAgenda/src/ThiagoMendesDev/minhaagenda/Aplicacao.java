package ThiagoMendesDev.minhaagenda;

import java.io.IOException;

public class Aplicacao {
	
	private Menu menu;
	
	private Agenda agenda;
	
	public void iniciar() throws IOException{
		
		menu = new Menu();
		agenda = new Agenda();
		
		int opcao = 0;
		
		while(opcao != Menu.OPCAO_SAIR) {
			try {
				
			opcao = menu.exibirOpcoes();
			
			switch(opcao) {
			case Menu.OPCAO_INSERIR:
				inserir();
				break;
			/*case Menu.OPCAO_ALTERAR;
				altera();
				break;
			case Menu.OPCAO_EXCLUIR;
				excluir();
				break;
			case Menu.OPCAO_LISTAR_LETRA;
				listarPorLetra();
				break;
			case Menu.OPCAO_PROCURAR;
				procurar();
				break;*/
			}
			
			} catch (AgendaException e) {
				System.out.println("Erro: " + e.getMessage());
				System.out.println();
			}
		}
		
		System.out.println("Fim da Aplicação");
	}
	
	public void inserir() throws AgendaException, IOException{
		System.out.println("Nome: ");
		String nome = Console.readString();
		System.out.println("Telefone: ");
		String telefone = Console.readString();
		
		Contato contato = new Contato(nome, telefone);
		agenda.inserir(contato);
		
		System.out.println("Contato inserido!");
		System.out.println();
		
	}
}
